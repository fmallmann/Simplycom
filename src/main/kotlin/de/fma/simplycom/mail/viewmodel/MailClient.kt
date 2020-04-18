package de.fma.simplycom.mail.viewmodel

import com.sun.mail.imap.IMAPFolder
import java.io.Closeable
import java.util.Date
import java.util.Properties
import javax.mail.Authenticator
import javax.mail.Flags
import javax.mail.Folder
import javax.mail.Message
import javax.mail.PasswordAuthentication
import javax.mail.Session
import javax.mail.Store
import javax.mail.Transport
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

fun connect(connectionInformation: ConnectionInformation, props: Properties = Properties(), action: Client.() -> Unit) {
    val session = Session.getInstance(props, PasswordAuthenticator(connectionInformation.user, connectionInformation.password))
    val store = session.getStore("imap")
    store.connect(connectionInformation)
    Client(session, store).use {
        it.action()
    }
}

class PasswordAuthenticator(val username: String, val password: String) : Authenticator() {
    override fun getPasswordAuthentication(): PasswordAuthentication = PasswordAuthentication(username, password)
}

data class ConnectionInformation(
        val host: String,
        val port: Int,
        val user: String,
        val password: String)

class Client internal constructor(private val session: Session, private val store: Store) : Closeable, AutoCloseable {
    override fun close() {
        store.close()
    }

    fun send(action: MailMessage.() -> Unit): Message {
        val message = MimeMessage(session)
        MailMessage(message).let {
            it.action()
        }
        message.saveChanges()
        Transport.send(message)
        return message
    }

    fun folder(name: String, access: Int = Folder.READ_ONLY, action: MailFolder.() -> Unit) {
        val imapFolder = store.getFolder(name) as IMAPFolder
        imapFolder.open(access)
        val mailFolder = MailFolder(imapFolder)
        mailFolder.action()
        imapFolder.close(false)
    }

    fun listFolders() {
        store.defaultFolder.list().forEach {
            println(it.name)
        }
    }
}

class MailMessage(val message: Message) {

    fun from(email: String, name: String = "") {
        message.setFrom(InternetAddress(email, name))
    }

    fun to(email: String) {
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email))
    }

    fun subject(subject: String) {
        message.subject = subject
    }

    fun text(text: String) {
        message.setText(text)
    }

}

class MailFolder(val folder: IMAPFolder) {

    fun readAll(): List<Mail> {
        return folder.messages.map {
            Mail(it)
        }
    }

    fun save(message: Message) {
        message.setFlag(Flags.Flag.SEEN, true)
        folder.appendMessages(arrayOf(message))
    }
}

class Mail(message: Message) {

    val mailInfo = MailInfo(message.subject, message.receivedDate, message.from.first() as InternetAddress)
}

data class MailInfo(
        val subject: String,
        val date: Date,
        val from: InternetAddress
)

fun Store.connect(connectionInformation: ConnectionInformation) = this.connect(
        connectionInformation.host,
        connectionInformation.port,
        connectionInformation.user,
        connectionInformation.password
)

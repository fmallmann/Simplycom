package de.fma.simplycom.mail.viewmodel

import com.sun.mail.imap.IMAPFolder
import tornadofx.Controller
import java.io.Closeable
import java.util.Date
import java.util.Properties
import javax.mail.Folder
import javax.mail.Message
import javax.mail.Session
import javax.mail.Store
import javax.mail.internet.InternetAddress

class MailService : Controller() {

    val connectionInformation = ConnectionInformation("host", 993, "user", "pw")
    val mailProperties = Properties()

    init {
        mailProperties.setProperty("mail.imap.ssl.enable", "true")
    }

    fun receiveMails(): MutableList<MailInfo> {
        var mailInfos = mutableListOf<MailInfo>()
        connect(connectionInformation, mailProperties) {
            folder("INBOX") {
                mailInfos = readAll().map { it.mailInfo }.toMutableList()
            }
        }
        return mailInfos
    }
}

fun connect(connectionInformation: ConnectionInformation, props: Properties = Properties(), action: Imap.() -> Unit) {
    val session = Session.getInstance(props)
    val store = session.getStore("imap")
    store.connect(connectionInformation)
    Imap(store).use {
        it.action()
    }
}

data class ConnectionInformation(
        val host: String,
        val port: Int,
        val user: String,
        val password: String)

class Imap internal constructor(private val store: Store) : Closeable, AutoCloseable {
    override fun close() {
        store.close()
    }

    fun folder(name: String, action: MailFolder.() -> Unit) {
        val imapFolder = store.getFolder(name) as IMAPFolder
        imapFolder.open(Folder.READ_ONLY)
        val mailFolder = MailFolder(imapFolder)
        mailFolder.action()
        imapFolder.close(false)
    }
}

class MailFolder(val folder: IMAPFolder) {

    fun readAll(): List<Mail> {
        return folder.messages.map {
            Mail(it)
        }
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

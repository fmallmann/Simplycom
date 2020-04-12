package de.fma.simplycom.board.viewmodel

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.deleteAll
import org.jetbrains.exposed.sql.transactions.transaction
import tornadofx.Controller

class MailRepository : Controller() {

    init {
        Database.connect("jdbc:h2:~/test", driver = "org.h2.Driver")
        transaction {
            SchemaUtils.create(MailPropertiesTable)
        }
    }

    fun load(): MailPropertiesEntity? {
        var mailPreferencesEntity: MailPropertiesEntity? = null
        transaction {
            val mailEntities = MailPropertiesEntity.all()
            mailPreferencesEntity = if (!mailEntities.empty()) mailEntities.first() else null
        }
        return mailPreferencesEntity
    }

    fun save(imapHostname: String, smtpHostname: String, port: Int, enableSsl: Boolean, username: String, password: String) {
        transaction {
            MailPropertiesTable.deleteAll()
            MailPropertiesEntity.new {
                this.imapHostname = imapHostname
                this.smtpHostname = smtpHostname
                this.port = port
                this.enableSsl = enableSsl
                this.username = username
                this.password = password
            }
        }
    }
}

object MailPropertiesTable : IntIdTable("mailProperties") {
    val imapHostname = varchar("imapHostname", 255)
    val smtpHostname = varchar("smtpHostname", 255)
    val port = integer("port")
    val enableSsl = bool("enableSsl")
    val username = varchar("username", 255)
    val password = varchar("password", 255)
}

class MailPropertiesEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<MailPropertiesEntity>(MailPropertiesTable)

    var imapHostname by MailPropertiesTable.imapHostname
    var smtpHostname by MailPropertiesTable.smtpHostname
    var port by MailPropertiesTable.port
    var enableSsl by MailPropertiesTable.enableSsl
    var username by MailPropertiesTable.username
    var password by MailPropertiesTable.password
}

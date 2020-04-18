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

    fun save(shownName: String, imapHostname: String, smtpHostname: String, imapPort: Int, smtpPort: Int, enableSsl: Boolean, username: String, password: String) {
        transaction {
            MailPropertiesTable.deleteAll()
            MailPropertiesEntity.new {
                this.shownName = shownName
                this.imapHostname = imapHostname
                this.smtpHostname = smtpHostname
                this.imapPort = imapPort
                this.smtpPort = smtpPort
                this.enableSsl = enableSsl
                this.username = username
                this.password = password
            }
        }
    }
}

object MailPropertiesTable : IntIdTable("mailProperties") {
    val shownName = varchar("shownName", 255)
    val imapHostname = varchar("imapHostname", 255)
    val smtpHostname = varchar("smtpHostname", 255)
    val imapPort = integer("imapPort")
    val smtpPort = integer("smtpPort")
    val enableSsl = bool("enableSsl")
    val username = varchar("username", 255)
    val password = varchar("password", 255)
}

class MailPropertiesEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<MailPropertiesEntity>(MailPropertiesTable)

    var shownName by MailPropertiesTable.shownName
    var imapHostname by MailPropertiesTable.imapHostname
    var smtpHostname by MailPropertiesTable.smtpHostname
    var imapPort by MailPropertiesTable.imapPort
    var smtpPort by MailPropertiesTable.smtpPort
    var enableSsl by MailPropertiesTable.enableSsl
    var username by MailPropertiesTable.username
    var password by MailPropertiesTable.password
}

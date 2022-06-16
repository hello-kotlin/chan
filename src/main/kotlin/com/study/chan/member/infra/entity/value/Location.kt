package com.study.chan.member.infra.entity.value

import com.study.chan.member.domain.LocationValue
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class Location(
    @Column(name = Col.country)
    override val country: String?,
    @Column(name = Col.city)
    override val city: String?
) : LocationValue {
    object Col {
        const val country = "country"
        const val city = "city"
    }
}
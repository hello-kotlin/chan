package com.study.chan.member.infra.entity.value

import com.study.chan.member.domain.value.AddressValue
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class Address(
    @Column(name = Col.zipCode)
    override val zipCode: String?,
    @Column(name = Col.address)
    override val address: String?,
    @Column(name = Col.addressDetail)
    override val addressDetail: String?
) : AddressValue {
    object Col {
        const val zipCode = "zipCode"
        const val address = "address"
        const val addressDetail = "addressDetail"
    }
}
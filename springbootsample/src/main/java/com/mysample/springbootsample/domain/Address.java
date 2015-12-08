/*******************************************************************************
 * Copyright 2015 Brient Oh @ Pristine Core
 * boh@pristinecore.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.mysample.springbootsample.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long addrId;
	
	@Column(name = "address1", length = 256)
	private String address1;

	@Column(name = "address2", length = 256)
	private String address2;

	@Column(name = "city", length = 256)
	private String addrCity;

	@Column(name = "state", length = 64)
	private String addrState;

	@Column(name = "zip_code", length = 32)
	private String zipCode;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	/**
	 * @return the addrId
	 */
	public Long getAddrId() {
		return addrId;
	}

	/**
	 * @param addrId the addrId to set
	 */
	public void setAddrId(Long addrId) {
		this.addrId = addrId;
	}

	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}

	/**
	 * @param address1 the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	/**
	 * @return the addrCity
	 */
	public String getAddrCity() {
		return addrCity;
	}

	/**
	 * @param addrCity the addrCity to set
	 */
	public void setAddrCity(String addrCity) {
		this.addrCity = addrCity;
	}

	/**
	 * @return the addrState
	 */
	public String getAddrState() {
		return addrState;
	}

	/**
	 * @param addrState the addrState to set
	 */
	public void setAddrState(String addrState) {
		this.addrState = addrState;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Address [addrId=" + addrId + ", address1=" + address1
				+ ", address2=" + address2 + ", addrCity=" + addrCity
				+ ", addrState=" + addrState + ", zipCode=" + zipCode + "]";
	}
	
}

package com.bridges.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Pattern;

public class Authorization {
	private String riskFunctionID;
	private String transactionCode;
	private String object;
	private String field;
	private String valueFrom;
	private String valueTo;
	private String operator;
	private boolean status;
	

	/**
	 * Construtor
	 * @param riskFunctionID
	 * @param transactionCode
	 * @param object
	 * @param field
	 * @param valueFrom
	 * @param valueTo
	 * @param operator
	 * @param status
	 */
	public Authorization(String riskFunctionID, String transactionCode,
			String object, String field, String valueFrom, String valueTo,
			String operator, boolean status) {
		super();
		this.setRiskFunctionID(riskFunctionID);
		this.transactionCode = transactionCode;
		this.object = object;
		this.field = field;
		this.valueFrom = valueFrom;
		this.valueTo = valueTo;
		this.operator = operator;
		this.status = status;
	}

	public String getTransactionCode() {
		return transactionCode;
	}

	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getValueFrom() {
		return valueFrom;
	}

	public void setValueFrom(String valueFrom) {
		this.valueFrom = valueFrom;
	}

	public String getValueTo() {
		return valueTo;
	}

	public void setValueTo(String valueTo) {
		this.valueTo = valueTo;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getRiskFunctionID() {
		return riskFunctionID;
	}

	public void setRiskFunctionID(String riskFunctionID) {
		this.riskFunctionID = riskFunctionID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((field == null) ? 0 : field.hashCode());
		result = prime * result + ((object == null) ? 0 : object.hashCode());
		result = prime * result
				+ ((operator == null) ? 0 : operator.hashCode());
		result = prime * result
				+ ((riskFunctionID == null) ? 0 : riskFunctionID.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		result = prime * result
				+ ((transactionCode == null) ? 0 : transactionCode.hashCode());
		result = prime * result
				+ ((valueFrom == null) ? 0 : valueFrom.hashCode());
		result = prime * result + ((valueTo == null) ? 0 : valueTo.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Authorization other = (Authorization) obj;
		if (field == null) {
			if (other.field != null)
				return false;
		} else if (!field.equals(other.field))
			return false;
		if (object == null) {
			if (other.object != null)
				return false;
		} else if (!object.equals(other.object))
			return false;
		if (operator == null) {
			if (other.operator != null)
				return false;
		} else if (!operator.equals(other.operator))
			return false;
		if (riskFunctionID == null) {
			if (other.riskFunctionID != null)
				return false;
		} else if (!riskFunctionID.equals(other.riskFunctionID))
			return false;
		if (status != other.status)
			return false;
		if (transactionCode == null) {
			if (other.transactionCode != null)
				return false;
		} else if (!transactionCode.equals(other.transactionCode))
			return false;
		if (valueFrom == null) {
			if (other.valueFrom != null)
				return false;
		} else if (!valueFrom.equals(other.valueFrom))
			return false;
		if (valueTo == null) {
			if (other.valueTo != null)
				return false;
		} else if (!valueTo.equals(other.valueTo))
			return false;
		return true;
	}
	
	

}

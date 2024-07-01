package in.cdac.design.prototype.invoice;

import in.cdac.design.prototype.configuration.ClonableObject;

public class Invoice implements ClonableObject<Invoice>{
    private Long invoiceId;
    private String customerName;
    private Double amount;
    private String paymentMethod;
    private InvoiceType type;

    public Invoice(Long invoiceId, String customerName, Double amount, String paymentMethod, InvoiceType type) {
        this.invoiceId = invoiceId;
        this.customerName = customerName;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.type = type;
    }
    private Invoice(Invoice copy)
    {
    	this.invoiceId=copy.invoiceId;
    	this.customerName=copy.customerName;
    	this.amount=copy.amount;
    	this.paymentMethod=copy.paymentMethod;
    	this.type=copy.type;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public InvoiceType getType() {
        return type;
    }

	@Override
	public Invoice cloneObject() {
		return new Invoice(this);
		
	}
	public void setType(InvoiceType type) {
		this.type = type;
	}
}
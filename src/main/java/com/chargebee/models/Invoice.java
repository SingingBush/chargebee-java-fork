package com.chargebee.models;

import com.chargebee.*;
import com.chargebee.internal.*;
import com.chargebee.internal.HttpUtil.Method;
import com.chargebee.models.enums.*;
import org.json.*;
import java.io.*;
import java.sql.Timestamp;
import java.util.*;

public class Invoice extends Resource<Invoice> {

    public enum Status {
        PAID,
        PAYMENT_DUE,
        NOT_PAID,
        VOIDED,
        PENDING,
        _UNKNOWN; /*Indicates unexpected value for this enum. You can get this when there is a
        java-client version incompatibility. We suggest you to upgrade to the latest version */
    }

    public enum DunningStatus {
        IN_PROGRESS,
        EXHAUSTED,
        STOPPED,
        SUCCESS,
        _UNKNOWN; /*Indicates unexpected value for this enum. You can get this when there is a
        java-client version incompatibility. We suggest you to upgrade to the latest version */
    }

    public static class LineItem extends Resource<LineItem> {
        public enum Type {
             CHARGE,PRORATED_CHARGE,SETUP_CHARGE,
            _UNKNOWN; /*Indicates unexpected value for this enum. You can get this when there is a
            java-client version incompatibility. We suggest you to upgrade to the latest version */ 
        }

        public enum EntityType {
             PLAN,ADDON,ADHOC,
            _UNKNOWN; /*Indicates unexpected value for this enum. You can get this when there is a
            java-client version incompatibility. We suggest you to upgrade to the latest version */ 
        }

        public LineItem(JSONObject jsonObj) {
            super(jsonObj);
        }

        public Timestamp dateFrom() {
            return reqTimestamp("date_from");
        }

        public Timestamp dateTo() {
            return reqTimestamp("date_to");
        }

        public Integer unitAmount() {
            return reqInteger("unit_amount");
        }

        public Integer quantity() {
            return optInteger("quantity");
        }

        public Boolean isTaxed() {
            return reqBoolean("is_taxed");
        }

        public Integer tax() {
            return optInteger("tax");
        }

        public Double taxRate() {
            return optDouble("tax_rate");
        }

        public Integer amount() {
            return reqInteger("amount");
        }

        public String description() {
            return reqString("description");
        }

        public Type type() {
            return reqEnum("type", Type.class);
        }

        public EntityType entityType() {
            return reqEnum("entity_type", EntityType.class);
        }

        public String entityId() {
            return optString("entity_id");
        }

    }

    public static class Discount extends Resource<Discount> {
        public enum Type {
             COUPON,CREDIT_ADJUSTMENT,ACCOUNT_CREDITS,
            _UNKNOWN; /*Indicates unexpected value for this enum. You can get this when there is a
            java-client version incompatibility. We suggest you to upgrade to the latest version */ 
        }

        public Discount(JSONObject jsonObj) {
            super(jsonObj);
        }

        public Integer amount() {
            return reqInteger("amount");
        }

        public String description() {
            return optString("description");
        }

        public Type type() {
            return reqEnum("type", Type.class);
        }

        public String entityId() {
            return optString("entity_id");
        }

    }

    public static class Tax extends Resource<Tax> {
        public Tax(JSONObject jsonObj) {
            super(jsonObj);
        }

        public Integer amount() {
            return reqInteger("amount");
        }

        public String description() {
            return optString("description");
        }

    }

    public static class LinkedTransaction extends Resource<LinkedTransaction> {
        public LinkedTransaction(JSONObject jsonObj) {
            super(jsonObj);
        }

        public String txnId() {
            return reqString("txn_id");
        }

        public Integer appliedAmount() {
            return reqInteger("applied_amount");
        }

        public Timestamp appliedAt() {
            return reqTimestamp("applied_at");
        }

        public Transaction.Type txnType() {
            return reqEnum("txn_type", Transaction.Type.class);
        }

        public Transaction.Status txnStatus() {
            return optEnum("txn_status", Transaction.Status.class);
        }

        public Timestamp txnDate() {
            return optTimestamp("txn_date");
        }

        public Integer txnAmount() {
            return optInteger("txn_amount");
        }

    }

    public static class LinkedOrder extends Resource<LinkedOrder> {
        public enum Status {
             NEW,PROCESSING,COMPLETE,CANCELLED,VOIDED,
            _UNKNOWN; /*Indicates unexpected value for this enum. You can get this when there is a
            java-client version incompatibility. We suggest you to upgrade to the latest version */ 
        }

        public LinkedOrder(JSONObject jsonObj) {
            super(jsonObj);
        }

        public String id() {
            return reqString("id");
        }

        public Status status() {
            return optEnum("status", Status.class);
        }

        public String referenceId() {
            return optString("reference_id");
        }

        public String fulfillmentStatus() {
            return optString("fulfillment_status");
        }

        public String batchId() {
            return optString("batch_id");
        }

        public Timestamp createdAt() {
            return reqTimestamp("created_at");
        }

    }

    public static class Note extends Resource<Note> {
        public enum EntityType {
             PLAN,ADDON,COUPON,SUBSCRIPTION,CUSTOMER,
            _UNKNOWN; /*Indicates unexpected value for this enum. You can get this when there is a
            java-client version incompatibility. We suggest you to upgrade to the latest version */ 
        }

        public Note(JSONObject jsonObj) {
            super(jsonObj);
        }

        public EntityType entityType() {
            return reqEnum("entity_type", EntityType.class);
        }

        public String note() {
            return reqString("note");
        }

        public String entityId() {
            return optString("entity_id");
        }

    }

    public static class ShippingAddress extends Resource<ShippingAddress> {
        public ShippingAddress(JSONObject jsonObj) {
            super(jsonObj);
        }

        public String firstName() {
            return optString("first_name");
        }

        public String lastName() {
            return optString("last_name");
        }

        public String email() {
            return optString("email");
        }

        public String company() {
            return optString("company");
        }

        public String phone() {
            return optString("phone");
        }

        public String line1() {
            return optString("line1");
        }

        public String line2() {
            return optString("line2");
        }

        public String line3() {
            return optString("line3");
        }

        public String city() {
            return optString("city");
        }

        public String stateCode() {
            return optString("state_code");
        }

        public String state() {
            return optString("state");
        }

        public String country() {
            return optString("country");
        }

        public String zip() {
            return optString("zip");
        }

    }

    public static class BillingAddress extends Resource<BillingAddress> {
        public BillingAddress(JSONObject jsonObj) {
            super(jsonObj);
        }

        public String firstName() {
            return optString("first_name");
        }

        public String lastName() {
            return optString("last_name");
        }

        public String email() {
            return optString("email");
        }

        public String company() {
            return optString("company");
        }

        public String phone() {
            return optString("phone");
        }

        public String line1() {
            return optString("line1");
        }

        public String line2() {
            return optString("line2");
        }

        public String line3() {
            return optString("line3");
        }

        public String city() {
            return optString("city");
        }

        public String stateCode() {
            return optString("state_code");
        }

        public String state() {
            return optString("state");
        }

        public String country() {
            return optString("country");
        }

        public String zip() {
            return optString("zip");
        }

    }

    //Constructors
    //============

    public Invoice(String jsonStr) {
        super(jsonStr);
    }

    public Invoice(JSONObject jsonObj) {
        super(jsonObj);
    }

    // Fields
    //=======

    public String id() {
        return reqString("id");
    }

    public String poNumber() {
        return optString("po_number");
    }

    public String customerId() {
        return reqString("customer_id");
    }

    public String subscriptionId() {
        return optString("subscription_id");
    }

    public Boolean recurring() {
        return reqBoolean("recurring");
    }

    public Status status() {
        return reqEnum("status", Status.class);
    }

    public String vatNumber() {
        return optString("vat_number");
    }

    public PriceType priceType() {
        return reqEnum("price_type", PriceType.class);
    }

    public Timestamp startDate() {
        return reqTimestamp("start_date");
    }

    public Timestamp endDate() {
        return optTimestamp("end_date");
    }

    public Integer amount() {
        return optInteger("amount");
    }

    public Integer amountPaid() {
        return optInteger("amount_paid");
    }

    public Integer amountAdjusted() {
        return optInteger("amount_adjusted");
    }

    public Integer creditsApplied() {
        return optInteger("credits_applied");
    }

    public Integer amountDue() {
        return optInteger("amount_due");
    }

    public Timestamp paidOn() {
        return optTimestamp("paid_on");
    }

    public DunningStatus dunningStatus() {
        return optEnum("dunning_status", DunningStatus.class);
    }

    public Timestamp nextRetry() {
        return optTimestamp("next_retry");
    }

    public Integer subTotal() {
        return reqInteger("sub_total");
    }

    public Integer tax() {
        return reqInteger("tax");
    }

    public Boolean firstInvoice() {
        return optBoolean("first_invoice");
    }

    public String currencyCode() {
        return optString("currency_code");
    }

    public List<Invoice.LineItem> lineItems() {
        return optList("line_items", Invoice.LineItem.class);
    }

    public List<Invoice.Discount> discounts() {
        return optList("discounts", Invoice.Discount.class);
    }

    public List<Invoice.Tax> taxes() {
        return optList("taxes", Invoice.Tax.class);
    }

    public List<Invoice.LinkedTransaction> linkedTransactions() {
        return optList("linked_transactions", Invoice.LinkedTransaction.class);
    }

    public List<Invoice.LinkedOrder> linkedOrders() {
        return optList("linked_orders", Invoice.LinkedOrder.class);
    }

    public List<Invoice.Note> notes() {
        return optList("notes", Invoice.Note.class);
    }

    public Invoice.ShippingAddress shippingAddress() {
        return optSubResource("shipping_address", Invoice.ShippingAddress.class);
    }

    public Invoice.BillingAddress billingAddress() {
        return optSubResource("billing_address", Invoice.BillingAddress.class);
    }

    // Operations
    //===========

    public static CreateRequest create() throws IOException {
        String uri = uri("invoices");
        return new CreateRequest(Method.POST, uri);
    }

    public static ChargeRequest charge() throws IOException {
        String uri = uri("invoices", "charge");
        return new ChargeRequest(Method.POST, uri);
    }

    public static ChargeAddonRequest chargeAddon() throws IOException {
        String uri = uri("invoices", "charge_addon");
        return new ChargeAddonRequest(Method.POST, uri);
    }

    public static Request stopDunning(String id) throws IOException {
        String uri = uri("invoices", nullCheck(id), "stop_dunning");
        return new Request(Method.POST, uri);
    }

    public static InvoiceListRequest list() throws IOException {
        String uri = uri("invoices");
        return new InvoiceListRequest(uri);
    }

    public static ListRequest invoicesForCustomer(String id) throws IOException {
        String uri = uri("customers", nullCheck(id), "invoices");
        return new ListRequest(uri);
    }

    public static ListRequest invoicesForSubscription(String id) throws IOException {
        String uri = uri("subscriptions", nullCheck(id), "invoices");
        return new ListRequest(uri);
    }

    public static Request retrieve(String id) throws IOException {
        String uri = uri("invoices", nullCheck(id));
        return new Request(Method.GET, uri);
    }

    public static Request pdf(String id) throws IOException {
        String uri = uri("invoices", nullCheck(id), "pdf");
        return new Request(Method.POST, uri);
    }

    public static AddChargeRequest addCharge(String id) throws IOException {
        String uri = uri("invoices", nullCheck(id), "add_charge");
        return new AddChargeRequest(Method.POST, uri);
    }

    public static AddAddonChargeRequest addAddonCharge(String id) throws IOException {
        String uri = uri("invoices", nullCheck(id), "add_addon_charge");
        return new AddAddonChargeRequest(Method.POST, uri);
    }

    public static Request collect(String id) throws IOException {
        String uri = uri("invoices", nullCheck(id), "collect");
        return new Request(Method.POST, uri);
    }

    public static CollectPaymentRequest collectPayment(String id) throws IOException {
        String uri = uri("invoices", nullCheck(id), "collect_payment");
        return new CollectPaymentRequest(Method.POST, uri);
    }

    public static RefundRequest refund(String id) throws IOException {
        String uri = uri("invoices", nullCheck(id), "refund");
        return new RefundRequest(Method.POST, uri);
    }

    public static RecordRefundRequest recordRefund(String id) throws IOException {
        String uri = uri("invoices", nullCheck(id), "record_refund");
        return new RecordRefundRequest(Method.POST, uri);
    }

    public static VoidInvoiceRequest voidInvoice(String id) throws IOException {
        String uri = uri("invoices", nullCheck(id), "void");
        return new VoidInvoiceRequest(Method.POST, uri);
    }

    public static DeleteRequest delete(String id) throws IOException {
        String uri = uri("invoices", nullCheck(id), "delete");
        return new DeleteRequest(Method.POST, uri);
    }


    // Operation Request Classes
    //==========================

    public static class CreateRequest extends Request<CreateRequest> {

        private CreateRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public CreateRequest customerId(String customerId) {
            params.add("customer_id", customerId);
            return this;
        }


        public CreateRequest coupon(String coupon) {
            params.addOpt("coupon", coupon);
            return this;
        }


        public CreateRequest poNumber(String poNumber) {
            params.addOpt("po_number", poNumber);
            return this;
        }


        public CreateRequest replacePrimaryPaymentSource(Boolean replacePrimaryPaymentSource) {
            params.addOpt("replace_primary_payment_source", replacePrimaryPaymentSource);
            return this;
        }


        public CreateRequest shippingAddressFirstName(String shippingAddressFirstName) {
            params.addOpt("shipping_address[first_name]", shippingAddressFirstName);
            return this;
        }

        public CreateRequest shippingAddressLastName(String shippingAddressLastName) {
            params.addOpt("shipping_address[last_name]", shippingAddressLastName);
            return this;
        }

        public CreateRequest shippingAddressEmail(String shippingAddressEmail) {
            params.addOpt("shipping_address[email]", shippingAddressEmail);
            return this;
        }

        public CreateRequest shippingAddressCompany(String shippingAddressCompany) {
            params.addOpt("shipping_address[company]", shippingAddressCompany);
            return this;
        }

        public CreateRequest shippingAddressPhone(String shippingAddressPhone) {
            params.addOpt("shipping_address[phone]", shippingAddressPhone);
            return this;
        }

        public CreateRequest shippingAddressLine1(String shippingAddressLine1) {
            params.addOpt("shipping_address[line1]", shippingAddressLine1);
            return this;
        }

        public CreateRequest shippingAddressLine2(String shippingAddressLine2) {
            params.addOpt("shipping_address[line2]", shippingAddressLine2);
            return this;
        }

        public CreateRequest shippingAddressLine3(String shippingAddressLine3) {
            params.addOpt("shipping_address[line3]", shippingAddressLine3);
            return this;
        }

        public CreateRequest shippingAddressCity(String shippingAddressCity) {
            params.addOpt("shipping_address[city]", shippingAddressCity);
            return this;
        }

        public CreateRequest shippingAddressStateCode(String shippingAddressStateCode) {
            params.addOpt("shipping_address[state_code]", shippingAddressStateCode);
            return this;
        }

        public CreateRequest shippingAddressState(String shippingAddressState) {
            params.addOpt("shipping_address[state]", shippingAddressState);
            return this;
        }

        public CreateRequest shippingAddressZip(String shippingAddressZip) {
            params.addOpt("shipping_address[zip]", shippingAddressZip);
            return this;
        }

        public CreateRequest shippingAddressCountry(String shippingAddressCountry) {
            params.addOpt("shipping_address[country]", shippingAddressCountry);
            return this;
        }

        public CreateRequest paymentIntentId(String paymentIntentId) {
            params.addOpt("payment_intent[id]", paymentIntentId);
            return this;
        }

        public CreateRequest paymentIntentGatewayAccountId(String paymentIntentGatewayAccountId) {
            params.addOpt("payment_intent[gateway_account_id]", paymentIntentGatewayAccountId);
            return this;
        }

        public CreateRequest paymentIntentGwToken(String paymentIntentGwToken) {
            params.addOpt("payment_intent[gw_token]", paymentIntentGwToken);
            return this;
        }

        public CreateRequest paymentIntentGwPaymentMethodId(String paymentIntentGwPaymentMethodId) {
            params.addOpt("payment_intent[gw_payment_method_id]", paymentIntentGwPaymentMethodId);
            return this;
        }

        public CreateRequest addonId(int index, String addonId) {
            params.addOpt("addons[id][" + index + "]", addonId);
            return this;
        }

        public CreateRequest addonQuantity(int index, Integer addonQuantity) {
            params.addOpt("addons[quantity][" + index + "]", addonQuantity);
            return this;
        }

        public CreateRequest chargeAmount(int index, Integer chargeAmount) {
            params.addOpt("charges[amount][" + index + "]", chargeAmount);
            return this;
        }

        public CreateRequest chargeDescription(int index, String chargeDescription) {
            params.addOpt("charges[description][" + index + "]", chargeDescription);
            return this;
        }

        @Override
        public Params params() {
            return params;
        }
    }

    public static class ChargeRequest extends Request<ChargeRequest> {

        private ChargeRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public ChargeRequest customerId(String customerId) {
            params.addOpt("customer_id", customerId);
            return this;
        }


        public ChargeRequest subscriptionId(String subscriptionId) {
            params.addOpt("subscription_id", subscriptionId);
            return this;
        }


        public ChargeRequest amount(Integer amount) {
            params.add("amount", amount);
            return this;
        }


        public ChargeRequest description(String description) {
            params.add("description", description);
            return this;
        }


        public ChargeRequest coupon(String coupon) {
            params.addOpt("coupon", coupon);
            return this;
        }


        public ChargeRequest poNumber(String poNumber) {
            params.addOpt("po_number", poNumber);
            return this;
        }


        @Override
        public Params params() {
            return params;
        }
    }

    public static class ChargeAddonRequest extends Request<ChargeAddonRequest> {

        private ChargeAddonRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public ChargeAddonRequest customerId(String customerId) {
            params.addOpt("customer_id", customerId);
            return this;
        }


        public ChargeAddonRequest subscriptionId(String subscriptionId) {
            params.addOpt("subscription_id", subscriptionId);
            return this;
        }


        public ChargeAddonRequest addonId(String addonId) {
            params.add("addon_id", addonId);
            return this;
        }


        public ChargeAddonRequest addonQuantity(Integer addonQuantity) {
            params.addOpt("addon_quantity", addonQuantity);
            return this;
        }


        public ChargeAddonRequest coupon(String coupon) {
            params.addOpt("coupon", coupon);
            return this;
        }


        public ChargeAddonRequest poNumber(String poNumber) {
            params.addOpt("po_number", poNumber);
            return this;
        }


        @Override
        public Params params() {
            return params;
        }
    }

    public static class InvoiceListRequest extends ListRequest<InvoiceListRequest> {

        private InvoiceListRequest(String uri) {
            super(uri);
        }
    
        public InvoiceListRequest limit(Integer limit) {
            params.addOpt("limit", limit);
            return this;
        }


        public InvoiceListRequest offset(String offset) {
            params.addOpt("offset", offset);
            return this;
        }


        public InvoiceListRequest paidOnAfter(Timestamp paidOnAfter) {
            params.addOpt("paid_on_after", paidOnAfter);
            return this;
        }


        @Override
        public Params params() {
            return params;
        }
    }

    public static class AddChargeRequest extends Request<AddChargeRequest> {

        private AddChargeRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public AddChargeRequest amount(Integer amount) {
            params.add("amount", amount);
            return this;
        }


        public AddChargeRequest description(String description) {
            params.add("description", description);
            return this;
        }


        @Override
        public Params params() {
            return params;
        }
    }

    public static class AddAddonChargeRequest extends Request<AddAddonChargeRequest> {

        private AddAddonChargeRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public AddAddonChargeRequest addonId(String addonId) {
            params.add("addon_id", addonId);
            return this;
        }


        public AddAddonChargeRequest addonQuantity(Integer addonQuantity) {
            params.addOpt("addon_quantity", addonQuantity);
            return this;
        }


        @Override
        public Params params() {
            return params;
        }
    }

    public static class CollectPaymentRequest extends Request<CollectPaymentRequest> {

        private CollectPaymentRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public CollectPaymentRequest amount(Integer amount) {
            params.addOpt("amount", amount);
            return this;
        }


        @Override
        public Params params() {
            return params;
        }
    }

    public static class RefundRequest extends Request<RefundRequest> {

        private RefundRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public RefundRequest refundAmount(Integer refundAmount) {
            params.addOpt("refund_amount", refundAmount);
            return this;
        }


        public RefundRequest memo(String memo) {
            params.addOpt("memo", memo);
            return this;
        }


        @Override
        public Params params() {
            return params;
        }
    }

    public static class RecordRefundRequest extends Request<RecordRefundRequest> {

        private RecordRefundRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public RecordRefundRequest memo(String memo) {
            params.add("memo", memo);
            return this;
        }


        public RecordRefundRequest transactionAmount(Integer transactionAmount) {
            params.addOpt("transaction[amount]", transactionAmount);
            return this;
        }

        public RecordRefundRequest transactionPaymentMethod(PaymentMethod transactionPaymentMethod) {
            params.add("transaction[payment_method]", transactionPaymentMethod);
            return this;
        }

        public RecordRefundRequest transactionReferenceNumber(String transactionReferenceNumber) {
            params.addOpt("transaction[reference_number]", transactionReferenceNumber);
            return this;
        }

        public RecordRefundRequest transactionDate(Timestamp transactionDate) {
            params.add("transaction[date]", transactionDate);
            return this;
        }

        @Override
        public Params params() {
            return params;
        }
    }

    public static class VoidInvoiceRequest extends Request<VoidInvoiceRequest> {

        private VoidInvoiceRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public VoidInvoiceRequest comment(String comment) {
            params.addOpt("comment", comment);
            return this;
        }


        @Override
        public Params params() {
            return params;
        }
    }

    public static class DeleteRequest extends Request<DeleteRequest> {

        private DeleteRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public DeleteRequest comment(String comment) {
            params.addOpt("comment", comment);
            return this;
        }


        @Override
        public Params params() {
            return params;
        }
    }

}

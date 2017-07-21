package com.chargebee.models.enums;

public enum EventType {
    PLAN_CREATED,
    PLAN_UPDATED,
    PLAN_DELETED,
    ADDON_CREATED,
    ADDON_UPDATED,
    ADDON_DELETED,
    COUPON_CREATED,
    COUPON_UPDATED,
    COUPON_DELETED,
    CUSTOMER_CREATED,
    CUSTOMER_CHANGED,
    CUSTOMER_DELETED,
    CUSTOMER_MOVED_OUT,
    CUSTOMER_MOVED_IN,
    SUBSCRIPTION_CREATED,
    SUBSCRIPTION_STARTED,
    SUBSCRIPTION_TRIAL_END_REMINDER,
    SUBSCRIPTION_ACTIVATED,
    SUBSCRIPTION_CHANGED,
    SUBSCRIPTION_CANCELLATION_SCHEDULED,
    SUBSCRIPTION_CANCELLATION_REMINDER,
    SUBSCRIPTION_CANCELLED,
    SUBSCRIPTION_REACTIVATED,
    SUBSCRIPTION_RENEWED,
    SUBSCRIPTION_SCHEDULED_CANCELLATION_REMOVED,
    SUBSCRIPTION_SHIPPING_ADDRESS_UPDATED,
    SUBSCRIPTION_DELETED,
    PENDING_INVOICE_CREATED,
    INVOICE_GENERATED,
    INVOICE_UPDATED,
    INVOICE_DELETED,
    CREDIT_NOTE_CREATED,
    CREDIT_NOTE_UPDATED,
    CREDIT_NOTE_DELETED,
    SUBSCRIPTION_RENEWAL_REMINDER,
    TRANSACTION_CREATED,
    TRANSACTION_UPDATED,
    TRANSACTION_DELETED,
    PAYMENT_SUCCEEDED,
    PAYMENT_FAILED,
    PAYMENT_REFUNDED,
    PAYMENT_INITIATED,
    REFUND_INITIATED,
    NETD_PAYMENT_DUE_REMINDER,
    CARD_ADDED,
    CARD_UPDATED,
    CARD_EXPIRY_REMINDER,
    CARD_EXPIRED,
    CARD_DELETED,
    PAYMENT_SOURCE_ADDED,
    PAYMENT_SOURCE_UPDATED,
    PAYMENT_SOURCE_DELETED,
    UNBILLED_CHARGES_CREATED,
    UNBILLED_CHARGES_VOIDED,
    UNBILLED_CHARGES_DELETED,
    UNBILLED_CHARGES_INVOICED,
    _UNKNOWN; /*Indicates unexpected value for this enum. You can get this when there is a
    java-client version incompatibility. We suggest you to upgrade to the latest version */
}
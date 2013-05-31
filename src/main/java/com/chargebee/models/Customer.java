package com.chargebee.models;

import com.chargebee.*;
import com.chargebee.internal.*;
import com.chargebee.internal.HttpUtil.Method;
import com.chargebee.models.enums.*;
import org.json.*;
import java.io.*;
import java.sql.Timestamp;
import java.util.*;

public class Customer extends Resource<Customer> {

    public enum CardStatus {
        NO_CARD,
        VALID,
        EXPIRING,
        EXPIRED,
        _UNKNOWN; /*Indicates unexpected value for this enum. You can get this when there is a
        java-client version incompatibility. We suggest you to upgrade to the latest version */
    }

    //Constructors
    //============

    public Customer(String jsonStr) {
        super(jsonStr);
    }

    public Customer(JSONObject jsonObj) {
        super(jsonObj);
    }

    // Fields
    //=======

    public String id() {
        return reqString("id");
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

    public String vatNumber() {
        return optString("vat_number");
    }

    public AutoCollection autoCollection() {
        return reqEnum("auto_collection", AutoCollection.class);
    }

    public Timestamp createdAt() {
        return reqTimestamp("created_at");
    }

    public CardStatus cardStatus() {
        return optEnum("card_status", CardStatus.class);
    }

    // Operations
    //===========

    public static ListRequest list() throws IOException {
        String uri = uri("customers");
        return new ListRequest(uri);
    }

    public static Request retrieve(String id) throws IOException {
        String uri = uri("customers", nullCheck(id));
        return new Request(Method.GET, uri);
    }

    public static UpdateRequest update(String id) throws IOException {
        String uri = uri("customers", nullCheck(id));
        return new UpdateRequest(Method.POST, uri);
    }


    // Operation Request Classes
    //==========================

    public static class UpdateRequest extends Request<UpdateRequest> {

        private UpdateRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public UpdateRequest firstName(String firstName) {
            params.addOpt("first_name", firstName);
            return this;
        }

        public UpdateRequest lastName(String lastName) {
            params.addOpt("last_name", lastName);
            return this;
        }

        public UpdateRequest email(String email) {
            params.addOpt("email", email);
            return this;
        }

        public UpdateRequest company(String company) {
            params.addOpt("company", company);
            return this;
        }

        @Override
        public Params params() {
            return params;
        }
    }

}

package com.example.verisioning_of_RestAPI.controller;

import com.example.verisioning_of_RestAPI.dto.PaymentMethod;
import com.example.verisioning_of_RestAPI.dto.PaymentV1DTO;
import com.example.verisioning_of_RestAPI.dto.PaymentV2DTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    //    path based versioning
//    @GetMapping(value = "/{version}", version = "v1")
//    public PaymentV1DTO pathVersion1() {
//        return new PaymentV1DTO(
//                10,
//                "INR",
//                "UPI");
//    }
//
//    @GetMapping(value = "/{version}", version = "v2")
//    public PaymentV2DTO paymentVersion2() {
//        return new PaymentV2DTO(
//                10,
//                "INR",
//                2,
//                "Full_Refund",
//                new PaymentMethod("UPI", "Google Pay"));
//    }

    //    header based versioning
//    @GetMapping(version = "v1")
//    public PaymentV1DTO headerBasedVersion1() {
//        return new PaymentV1DTO(
//                10,
//                "INR",
//                "UPI");
//    }
//
//    @GetMapping(version = "v2")
//    public PaymentV2DTO headerBasedVersion2() {
//        return new PaymentV2DTO(
//                10,
//                "INR",
//                2,
//                "Full_Refund",
//                new PaymentMethod("UPI", "Google Pay"));
//    }

    //    param based versioning
//    one way with using application .properties with query-param
//    @GetMapping(version = "v1")
//    public PaymentV1DTO paramBasedVersion1() {
//        return new PaymentV1DTO(
//                10,
//                "INR",
//                "UPI");
//    }
//
//    @GetMapping(version = "v2")
//    public PaymentV2DTO paramBasedVersion2() {
//        return new PaymentV2DTO(
//                10,
//                "INR",
//                2,
//                "Full_Refund",
//                new PaymentMethod("UPI", "Google Pay"));
//    }
//
//    param without application.property using version
    @GetMapping(params = "version=v1")
    public PaymentV1DTO paramBasedVersion1() {
        return new PaymentV1DTO(
                10,
                "INR",
                "UPI");
    }

    @GetMapping(params = "version=v2")
    public PaymentV2DTO paramBasedVersion2() {
        return new PaymentV2DTO(
                10,
                "INR",
                2,
                "Full_Refund",
                new PaymentMethod("UPI", "Google Pay"));
    }
}

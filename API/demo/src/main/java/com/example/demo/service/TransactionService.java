package com.example.demo.service;

import com.example.demo.dto.response.BaseResponse;
import com.example.demo.dto.request.TransactionRequest;
import com.example.demo.dto.response.TransactionResponse;

import java.util.List;

public interface TransactionService {
    BaseResponse createTransaction(String title,String description,double amount,int tagId);

    BaseResponse updateTransaction(TransactionRequest transactionRequestDTO, int id);

    void deleteTransaction(int id);

    List<TransactionResponse> getTransaction();
}
package com.inb.main.repository;

import java.util.List;

import com.inb.main.pojo.ChequeDetails;

public interface ChequeDetailsRepositoryInterface {

	boolean addChequeDetails(ChequeDetails chequeDetails);

	List<ChequeDetails> getAllChequeDetails();

	ChequeDetails getChequeDetailsByChequeNo(int chequeNo);

	List<ChequeDetails> getChequeDetailsByAccountId(int accounId);

	boolean chequeDetailsUpdate(ChequeDetails chequeDetails);

	List<ChequeDetails> getPendingCheque();

	boolean updateChequeDetails(ChequeDetails chequeDetails);

	boolean updateChequeStatus(ChequeDetails chequeDetails);

	boolean updateChequeToApproved(int chequeNo);

	boolean updateChequeToDeclined(int chequeNo);

}

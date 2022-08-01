package com.inb.main.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inb.main.pojo.ChequeDetails;
import com.inb.main.repository.ChequeDetailsRepositoryInterface;

@Service
public class ChequeDetailsService implements ChequeDetailsServiceInterface {

	@Autowired
	ChequeDetailsRepositoryInterface chequeDetailsRepositoryInterface;

	@Override
	public boolean addChequeDetails(ChequeDetails chequeDetails) {

		return chequeDetailsRepositoryInterface.addChequeDetails(chequeDetails);
	}

	@Override
	public List<ChequeDetails> getAllChequeDetails() {

		return chequeDetailsRepositoryInterface.getAllChequeDetails();
	}

	@Override
	public ChequeDetails getChequeDetailsByChequeNo(int chequeNo) {

		return chequeDetailsRepositoryInterface.getChequeDetailsByChequeNo(chequeNo);
	}

	@Override
	public List<ChequeDetails> getChequeDetailsByAccountId(int accountId) {

		return chequeDetailsRepositoryInterface.getChequeDetailsByAccountId(accountId);
	}

	@Override
	public boolean chequeDetailsUpdate(ChequeDetails chequeDetails) {

		ChequeDetails chequeTransaction = new ChequeDetails();
		chequeTransaction.setChequeNo(chequeDetails.getChequeNo());
		chequeTransaction.setAccountId(chequeDetails.getAccountId());
		chequeTransaction.setAccountIdTo(chequeDetails.getAccountIdTo());
		chequeTransaction.setDepositeAmount(chequeDetails.getDepositeAmount());
		chequeTransaction.setChequeDate(LocalDate.now());
		chequeTransaction.setChequeStatus(chequeDetails.getChequeStatus());

		boolean chequeTransactionStatus = chequeDetailsRepositoryInterface.updateChequeDetails(chequeTransaction);

		if (chequeTransactionStatus == true) {
			System.out.println("update successfull");
			return true;
		}
		return false;
	}

	@Override
	public List<ChequeDetails> getPendingCheque() {
		// TODO Auto-generated method stub
		return chequeDetailsRepositoryInterface.getPendingCheque();
	}

	@Override
	public boolean updateChequeDetails(ChequeDetails chequeDetails) {
		// TODO Auto-generated method stub
		return chequeDetailsRepositoryInterface.updateChequeDetails(chequeDetails);
	}

	@Override
	public boolean updateChequeStatus(ChequeDetails chequeDetails) {
		// TODO Auto-generated method stub
		return chequeDetailsRepositoryInterface.updateChequeStatus(chequeDetails);
	}

	@Override
	public boolean updateChequeToApproved(int chequeNo) {
		// TODO Auto-generated method stub
		return chequeDetailsRepositoryInterface.updateChequeToApproved(chequeNo);
	}

	@Override
	public boolean updateChequeToDeclined(int chequeNo) {
		// TODO Auto-generated method stub
		return chequeDetailsRepositoryInterface.updateChequeToDeclined(chequeNo);
	}

}

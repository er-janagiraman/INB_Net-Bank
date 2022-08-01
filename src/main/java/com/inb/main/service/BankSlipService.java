package com.inb.main.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inb.main.pojo.AccountDetails;
import com.inb.main.pojo.BankSlipDetails;
import com.inb.main.pojo.ChequeDetails;
import com.inb.main.pojo.TransactionDetails;
import com.inb.main.repository.AccountDetailsRepositoryInterface;
import com.inb.main.repository.BankSlipRepository;
import com.inb.main.repository.TransactiondetailsRepositoryInterface;

@Service
public class BankSlipService implements BankSlipServiceInterface {
	@Autowired
	BankSlipRepository bankSlipRepository;

	@Autowired
	private TransactiondetailsRepositoryInterface transactiondetailsRepositoryInterface;

	@Autowired
	private AccountDetailsRepositoryInterface accountDetailsRepositoryInterface;

	@Autowired
	ChequeDetailsServiceInterface chequeDetailsServiceInterface;

	@Override
	public boolean addBankSlipDetails(BankSlipDetails bankSlipDetails) {
		// TODO Auto-generated method stub
		return bankSlipRepository.addBankSlipDetails(bankSlipDetails);
	}

	@Override
	public List<BankSlipDetails> getAllBankSlipDetails() {

		return bankSlipRepository.getAllBankSlipDetails();
	}

	@Override
	public BankSlipDetails getBankSlipByChequeNo(int chequeNo) {
		// TODO Auto-generated method stub
		return bankSlipRepository.getBankSlipByChequeNo(chequeNo);
	}

	@Override
	public List<BankSlipDetails> getBankSlipByAccountId(int accountId) {

		return bankSlipRepository.getBankSlipByAccountId(accountId);
	}

	@Override
	public boolean chequeDepositTransaction(BankSlipDetails bankSlipDetails) {

		ChequeDetails chequeDetails = new ChequeDetails();

		AccountDetails accountDetailsFrom = bankSlipDetails.getAccountId();
		accountDetailsFrom = accountDetailsRepositoryInterface
				.getAccountDetailsByAccountId(accountDetailsFrom.getAccountId());

		AccountDetails accountDetailsTo = bankSlipDetails.getAccountIdTo();
		accountDetailsTo = accountDetailsRepositoryInterface
				.getAccountDetailsByAccountId(accountDetailsTo.getAccountId());

		if (bankSlipDetails.getChequeDetails().getChequeStatus().equals("cleared")) {

			if (accountDetailsFrom.getTypeOfAccount().equals("savings")) {
				if ((accountDetailsFrom.getCurrentBalance() - accountDetailsFrom.getMinimumBalance()) >= bankSlipDetails
						.getChequeDetails().getDepositeAmount()) {
					double amount = bankSlipDetails.getChequeDetails().getDepositeAmount();

					accountDetailsFrom.setCurrentBalance(accountDetailsFrom.getCurrentBalance() - amount);

					TransactionDetails depositeTransactionfrom = new TransactionDetails();

					depositeTransactionfrom.setAccountId(accountDetailsFrom);
					depositeTransactionfrom.setAccountIdTo(accountDetailsTo);
					depositeTransactionfrom.setTransactionAmount(amount);
					depositeTransactionfrom.setTransactionType("Cheque_Deposite");
					depositeTransactionfrom.setTransactionDate(LocalDate.now());
					depositeTransactionfrom.setTransactionTime(LocalTime.now());

					boolean depositeStatusFrom = transactiondetailsRepositoryInterface
							.addTransactionDetails(depositeTransactionfrom);

					accountDetailsTo.setCurrentBalance(accountDetailsTo.getCurrentBalance() + amount);

					TransactionDetails depositeTransactionTo = new TransactionDetails();
					depositeTransactionTo.setAccountId(accountDetailsTo);
					depositeTransactionTo.setAccountIdTo(accountDetailsFrom);
					depositeTransactionTo.setTransactionAmount(amount);
					depositeTransactionTo.setTransactionType("Cheque_Credited");
					depositeTransactionTo.setTransactionDate(LocalDate.now());
					depositeTransactionTo.setTransactionTime(LocalTime.now());

					boolean depositeStatusTo = transactiondetailsRepositoryInterface
							.addTransactionDetails(depositeTransactionTo);

					if (depositeStatusFrom == true && depositeStatusTo == true) {

						boolean updateAccountToBalanceStatus = accountDetailsRepositoryInterface
								.updateAccountDetails(accountDetailsTo);

						boolean updateAccountFromBalanceStatus = accountDetailsRepositoryInterface
								.updateAccountDetails(accountDetailsFrom);

						if (updateAccountToBalanceStatus && updateAccountFromBalanceStatus) {

							boolean updateStatus = chequeDetailsServiceInterface
									.updateChequeToApproved(bankSlipDetails.getChequeDetails().getChequeNo());

							return true;
						}
					}
				}
			}

			else if (accountDetailsFrom.getTypeOfAccount().equals("current")) {
				if ((accountDetailsFrom.getCurrentBalance()) >= bankSlipDetails.getChequeDetails()
						.getDepositeAmount()) {
					double amount = bankSlipDetails.getChequeDetails().getDepositeAmount();

					accountDetailsFrom.setCurrentBalance(accountDetailsFrom.getCurrentBalance() - amount);

					TransactionDetails depositeTransactionfrom = new TransactionDetails();

					depositeTransactionfrom.setAccountId(accountDetailsFrom);
					depositeTransactionfrom.setAccountIdTo(accountDetailsTo);
					depositeTransactionfrom.setTransactionAmount(amount);
					depositeTransactionfrom.setTransactionType("Cheque_Deposite");
					depositeTransactionfrom.setTransactionDate(LocalDate.now());
					depositeTransactionfrom.setTransactionTime(LocalTime.now());

					boolean depositeStatusFrom = transactiondetailsRepositoryInterface
							.addTransactionDetails(depositeTransactionfrom);

					accountDetailsTo.setCurrentBalance(accountDetailsTo.getCurrentBalance() + amount);

					TransactionDetails depositeTransactionTo = new TransactionDetails();
					depositeTransactionTo.setAccountId(accountDetailsTo);
					depositeTransactionTo.setAccountIdTo(accountDetailsFrom);
					depositeTransactionTo.setTransactionAmount(amount);
					depositeTransactionTo.setTransactionType("Cheque_Credited");
					depositeTransactionTo.setTransactionDate(LocalDate.now());
					depositeTransactionTo.setTransactionTime(LocalTime.now());

					boolean depositeStatusTo = transactiondetailsRepositoryInterface
							.addTransactionDetails(depositeTransactionTo);

					if (depositeStatusFrom == true && depositeStatusTo == true) {

						boolean updateAccountToBalanceStatus = accountDetailsRepositoryInterface
								.updateAccountDetails(accountDetailsTo);

						boolean updateAccountFromBalanceStatus = accountDetailsRepositoryInterface
								.updateAccountDetails(accountDetailsFrom);

						if (updateAccountToBalanceStatus && updateAccountFromBalanceStatus) {

							boolean updateStatus = chequeDetailsServiceInterface
									.updateChequeToApproved(bankSlipDetails.getChequeDetails().getChequeNo());

							return true;
						}
					}
				}

			}
		}

		else if (bankSlipDetails.getChequeDetails().getChequeStatus().equals("bounced")) {

			accountDetailsFrom.setCurrentBalance(accountDetailsFrom.getCurrentBalance() - 350.00);

			TransactionDetails depositeTransactionfrom = new TransactionDetails();

			depositeTransactionfrom.setAccountId(accountDetailsFrom);
			depositeTransactionfrom.setAccountIdTo(accountDetailsTo);
			depositeTransactionfrom.setTransactionAmount(350.00);
			depositeTransactionfrom.setTransactionType("Fine Amount");
			depositeTransactionfrom.setTransactionDate(LocalDate.now());
			depositeTransactionfrom.setTransactionTime(LocalTime.now());

			boolean depositeStatusFrom = transactiondetailsRepositoryInterface
					.addTransactionDetails(depositeTransactionfrom);

			if (depositeStatusFrom == true) {

				boolean updateAccountFromBalanceStatus = accountDetailsRepositoryInterface
						.updateAccountDetails(accountDetailsFrom);

				if (updateAccountFromBalanceStatus) {

					boolean updateStatus = chequeDetailsServiceInterface
							.updateChequeToDeclined(bankSlipDetails.getChequeDetails().getChequeNo());
				
					return true;
				}

			}

		}
		return false;
	}

}

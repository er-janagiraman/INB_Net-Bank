package com.inb.main.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inb.main.pojo.AccountDetails;
import com.inb.main.pojo.TransactionDetails;
import com.inb.main.repository.AccountDetailsRepositoryInterface;
import com.inb.main.repository.TransactiondetailsRepositoryInterface;

@Service
public class TransactionService implements TransactionServiceInterface {
	@Autowired
	private TransactiondetailsRepositoryInterface transactiondetailsRepositoryInterface;

	@Autowired
	private AccountDetailsRepositoryInterface accountDetailsRepositoryInterface;

	@Override
	public boolean addTransactionDetails(TransactionDetails transactionDetails) {

		return transactiondetailsRepositoryInterface.addTransactionDetails(transactionDetails);
	}

	@Override
	public List<TransactionDetails> getAllTransactionDetails() {

		return transactiondetailsRepositoryInterface.getAllTransactionDetails();
	}

	@Override
	public List<TransactionDetails> transactionDetailsByAccountId(String accountId) {

		return transactiondetailsRepositoryInterface.transactionDetailsByAccountId(accountId);
	}

	@Override
	public List<TransactionDetails> transactionDetailsByTransactiontId(int transactionId) {
		// TODO Auto-generated method stub
		return transactiondetailsRepositoryInterface.transactionDetailsByTransactiontId(transactionId);
	}

	@Override
	public boolean accountTransferTransaction(TransactionDetails transactionDetails) {

		AccountDetails accountDetailsFrom = transactionDetails.getAccountId();
		accountDetailsFrom = accountDetailsRepositoryInterface
				.getAccountDetailsByAccountId(accountDetailsFrom.getAccountId());

		AccountDetails accountDetailsTo = transactionDetails.getAccountIdTo();
		accountDetailsTo = accountDetailsRepositoryInterface
				.getAccountDetailsByAccountId(accountDetailsTo.getAccountId());

		if (accountDetailsFrom.getTypeOfAccount().equals("savings")) {

			if ((accountDetailsFrom.getCurrentBalance() - accountDetailsFrom.getMinimumBalance()) >= transactionDetails
					.getTransactionAmount()) {
				double amount = transactionDetails.getTransactionAmount();

				accountDetailsFrom.setCurrentBalance(accountDetailsFrom.getCurrentBalance() - amount);

				TransactionDetails withdrawTransaction = new TransactionDetails();
				withdrawTransaction.setAccountId(accountDetailsFrom);
				withdrawTransaction.setAccountIdTo(accountDetailsTo);
				withdrawTransaction.setTransactionAmount(amount);
				withdrawTransaction.setTransactionType("Debit");
				withdrawTransaction.setTransactionDate(LocalDate.now());
				withdrawTransaction.setTransactionTime(LocalTime.now());

				boolean withdrawTransactionStatus = transactiondetailsRepositoryInterface
						.addTransactionDetails(withdrawTransaction);

				accountDetailsTo.setCurrentBalance(accountDetailsTo.getCurrentBalance() + amount);

				TransactionDetails depositTransaction = new TransactionDetails();

				depositTransaction.setAccountId(accountDetailsTo);
				depositTransaction.setAccountIdTo(accountDetailsFrom);
				depositTransaction.setTransactionAmount(amount);
				depositTransaction.setTransactionType("Credit");
				depositTransaction.setTransactionDate(LocalDate.now());
				depositTransaction.setTransactionTime(LocalTime.now());

				boolean depositTransactionStatus = transactiondetailsRepositoryInterface
						.addTransactionDetails(depositTransaction);

				if (withdrawTransactionStatus == true && depositTransactionStatus == true) {
					boolean updateAccountToBalanceStatus = accountDetailsRepositoryInterface
							.updateAccountDetails(accountDetailsTo);

					boolean updateAccountFromBalanceStatus = accountDetailsRepositoryInterface
							.updateAccountDetails(accountDetailsFrom);

					if (updateAccountToBalanceStatus && updateAccountFromBalanceStatus) {

						return true;
					}
				}
			}
		} else if (accountDetailsFrom.getTypeOfAccount().equals("current")
				|| accountDetailsFrom.getTypeOfAccount().equals("fd")) {
			System.out.println("account is fd");
			if (accountDetailsFrom.getCurrentBalance() >= transactionDetails.getTransactionAmount()) {
				double amount = transactionDetails.getTransactionAmount();

				accountDetailsFrom.setCurrentBalance(accountDetailsFrom.getCurrentBalance() - amount);

				TransactionDetails withdrawTransaction = new TransactionDetails();
				withdrawTransaction.setAccountId(accountDetailsFrom);
				withdrawTransaction.setAccountIdTo(accountDetailsTo);
				withdrawTransaction.setTransactionAmount(amount);
				withdrawTransaction.setTransactionType("Debit");
				withdrawTransaction.setTransactionDate(LocalDate.now());
				withdrawTransaction.setTransactionTime(LocalTime.now());

				boolean withdrawTransactionStatus = transactiondetailsRepositoryInterface
						.addTransactionDetails(withdrawTransaction);

				accountDetailsTo.setCurrentBalance(accountDetailsTo.getCurrentBalance() + amount);

				TransactionDetails depositTransaction = new TransactionDetails();

				depositTransaction.setAccountId(accountDetailsTo);
				depositTransaction.setAccountIdTo(accountDetailsFrom);
				depositTransaction.setTransactionAmount(amount);
				depositTransaction.setTransactionType("Credit");
				depositTransaction.setTransactionDate(LocalDate.now());
				depositTransaction.setTransactionTime(LocalTime.now());

				boolean depositTransactionStatus = transactiondetailsRepositoryInterface
						.addTransactionDetails(depositTransaction);

				if (withdrawTransactionStatus == true && depositTransactionStatus == true) {
					boolean updateAccountToBalanceStatus = accountDetailsRepositoryInterface
							.updateAccountDetails(accountDetailsTo);

					boolean updateAccountFromBalanceStatus = accountDetailsRepositoryInterface
							.updateAccountDetails(accountDetailsFrom);

					if (updateAccountToBalanceStatus && updateAccountFromBalanceStatus) {

						return true;
					}
				}
			}
		}

		return false;
	}

	@Override
	public boolean fixedDepositeTransaction(TransactionDetails transactionDetails) {

		AccountDetails accountDetailsFrom = transactionDetails.getAccountId();
		accountDetailsFrom = accountDetailsRepositoryInterface
				.getAccountDetailsByAccountId(accountDetailsFrom.getAccountId());

		AccountDetails accountDetailsTo = transactionDetails.getAccountIdTo();
		accountDetailsTo = accountDetailsRepositoryInterface
				.getAccountDetailsByAccountId(accountDetailsTo.getAccountId());

		if (accountDetailsFrom.getTypeOfAccount().equals("savings"))

		{

			if ((accountDetailsFrom.getCurrentBalance() - accountDetailsFrom.getMinimumBalance()) >= transactionDetails
					.getTransactionAmount()) {
				double amount = transactionDetails.getTransactionAmount();

				accountDetailsFrom.setCurrentBalance(accountDetailsFrom.getCurrentBalance() - amount);

				TransactionDetails withdrawTransaction = new TransactionDetails();
				withdrawTransaction.setAccountId(accountDetailsFrom);
				withdrawTransaction.setAccountIdTo(accountDetailsTo);
				withdrawTransaction.setTransactionAmount(amount);
				withdrawTransaction.setTransactionType("FixedDeposite");
				withdrawTransaction.setTransactionDate(LocalDate.now());
				withdrawTransaction.setTransactionTime(LocalTime.now());

				boolean withdrawTransactionStatus = transactiondetailsRepositoryInterface
						.addTransactionDetails(withdrawTransaction);

				accountDetailsTo.setCurrentBalance(accountDetailsTo.getCurrentBalance() + amount);

				TransactionDetails depositTransaction = new TransactionDetails();

				depositTransaction.setAccountId(accountDetailsTo);
				depositTransaction.setAccountIdTo(accountDetailsFrom);
				depositTransaction.setTransactionAmount(amount);
				depositTransaction.setTransactionType("FixedDeposite");
				depositTransaction.setTransactionDate(LocalDate.now());
				depositTransaction.setTransactionTime(LocalTime.now());

				boolean depositTransactionStatus = transactiondetailsRepositoryInterface
						.addTransactionDetails(depositTransaction);

				if (withdrawTransactionStatus == true && depositTransactionStatus == true) {
					boolean updateAccountToBalanceStatus = accountDetailsRepositoryInterface
							.updateAccountDetails(accountDetailsTo);

					boolean updateAccountFromBalanceStatus = accountDetailsRepositoryInterface
							.updateAccountDetails(accountDetailsFrom);

					if (updateAccountToBalanceStatus && updateAccountFromBalanceStatus) {
						System.out.println(" From Savings Account :: Transaction Success");

						return true;
					}
				}
			}
		} else if (accountDetailsFrom.getTypeOfAccount().equals("current")) {

			if (accountDetailsFrom.getCurrentBalance() >= transactionDetails.getTransactionAmount()) {
				double amount = transactionDetails.getTransactionAmount();

				accountDetailsFrom.setCurrentBalance(accountDetailsFrom.getCurrentBalance() - amount);

				TransactionDetails withdrawTransaction = new TransactionDetails();
				withdrawTransaction.setAccountId(accountDetailsFrom);
				withdrawTransaction.setAccountIdTo(accountDetailsTo);
				withdrawTransaction.setTransactionAmount(amount);
				withdrawTransaction.setTransactionType("FixedDeposite");
				withdrawTransaction.setTransactionDate(LocalDate.now());
				withdrawTransaction.setTransactionTime(LocalTime.now());

				boolean withdrawTransactionStatus = transactiondetailsRepositoryInterface
						.addTransactionDetails(withdrawTransaction);

				accountDetailsTo.setCurrentBalance(accountDetailsTo.getCurrentBalance() + amount);

				TransactionDetails depositTransaction = new TransactionDetails();

				depositTransaction.setAccountId(accountDetailsTo);
				depositTransaction.setAccountIdTo(accountDetailsFrom);
				depositTransaction.setTransactionAmount(amount);
				depositTransaction.setTransactionType("FixedDeposite");
				depositTransaction.setTransactionDate(LocalDate.now());
				depositTransaction.setTransactionTime(LocalTime.now());

				boolean depositTransactionStatus = transactiondetailsRepositoryInterface
						.addTransactionDetails(depositTransaction);

				if (withdrawTransactionStatus == true && depositTransactionStatus == true) {
					boolean updateAccountToBalanceStatus = accountDetailsRepositoryInterface
							.updateAccountDetails(accountDetailsTo);

					boolean updateAccountFromBalanceStatus = accountDetailsRepositoryInterface
							.updateAccountDetails(accountDetailsFrom);

					if (updateAccountToBalanceStatus && updateAccountFromBalanceStatus) {

						return true;
					}
				}
			}

		}

		return false;

	}

}

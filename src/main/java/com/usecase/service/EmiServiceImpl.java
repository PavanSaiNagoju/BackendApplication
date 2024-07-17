package com.usecase.service;

public class EmiServiceImpl implements EmiService {

	@Override
	public double EMICalculate(double loanAmount, int terminYears, double interestRate) {
		int n = terminYears * 12; // Convert Term in Years to Months
		interestRate = interestRate / n; // Convert annual interest rate to monthly
		double powfunc = Math.pow((1 + (interestRate)) / 12, n);// Calculate Monthly Interest Rate
		double EMI = Math.round(loanAmount * (interestRate * 12) * ((powfunc) / (powfunc - 1)));// EMI formula in months
		return EMI;
	}

}

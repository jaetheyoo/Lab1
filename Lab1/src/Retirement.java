//Lab 1: Jae Yoo, Hunter Carpenter, Edwin Ortiz
//Github Accounts: Zenithrising, hccarpen, eortiz333
/**Retirement is a program that determines how much a user will need to save each month to have a steady stream of predictable income after he's done working.
 * Parameters: None
 * Return: None
 * Variables: 
 * 		Scanner input: a new Scanner
 * 		double MonthsWork: describes the months to work, calculated from years to work, an input
 * 		double MonthlyIncomeReturn: describes 1 plus the monthly interest from income portion, calculated from annual rate of return, an input
 * 		double MonthsRetired: describes the months retired, calculated from years retired, an input
 * 		double MonthlyPayoutReturn: describes 1 plus the monthly interest from payout portion, calculated from annual rate of return (payout), an input
 * 		double ReqIncome: describes the monthly required income user specifies
 * 		double Difference: the monthly difference you need to withdraw, calculated from ReqIncome and MonthlySSI, an input
 * 		double TotalAmountSaved: the total amount saved based on MonthsRetired, MonthlyPayoutReturn, and Difference rounded to 2 decimals
 * 		double MonthlySavings: the amount the user needs to save each month based on MonthsWork, MonthlyIncomeReturn, and TotalAmountSaved
 */
import java.util.Scanner;
public class Retirement {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // Create a Scanner object

		System.out.print("Enter your years to work: ");
		double MonthsWork = input.nextDouble() * 12; 
		
		System.out.print("Enter your annual rate of return as a decimal: ");
		double MonthlyIncomeReturn = 1 + input.nextDouble() / 12.;
		
		System.out.print("To calculate your payout, please enter the number of years you will be retired (Avg Life expectancy 87): ");
		double MonthsRetired = input.nextDouble() * 12.;
		
		System.out.print("Enter your annual payout return as a decimal: ");
		double MonthlyPayoutReturn = 1 + input.nextDouble() / 12.; 
		
		System.out.print("Enter your required MONTHLY income (min 75% of your current monthly income): ");
		double ReqIncome = input.nextDouble();
		
		System.out.print("Lastly, enter your Monthly SSI (if you earned the maximum income, and retired at age 65, Monthly SSI is $2,642): ");
		double Difference = ReqIncome - input.nextDouble(); 
		
		input.close();
		
		double TotalAmountSaved = Math.ceil(100 * (Math.pow(MonthlyPayoutReturn, MonthsRetired) - 1) * Difference / (MonthlyPayoutReturn - 1) / (Math.pow(MonthlyPayoutReturn, MonthsRetired))) / 100;
		double MonthlySavings = Math.ceil(100 * (TotalAmountSaved / ((Math.pow(MonthlyIncomeReturn, MonthsWork) - 1) / (MonthlyIncomeReturn - 1)))) / 100;

		System.out.println("You need to save " + MonthlySavings + " per month (the total amount you need saved is " + TotalAmountSaved + ").");
	}
}


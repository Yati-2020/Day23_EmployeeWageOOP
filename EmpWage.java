class CompanyEmpWage {
	public final String company;
	public final int empRatePerHr;
	public final int numberOfWorkingDays;
	public final int maxHrPerMonth;
	public int totalEmpWage;

	public CompanyEmpWage(String company, int empRatePerHr, int numberOfWorkingDays, int maxHrPerMonth) {
		this.company = company;
		this.empRatePerHr = empRatePerHr;
		this.numberOfWorkingDays = numberOfWorkingDays;
		this.maxHrPerMonth = maxHrPerMonth;

	}
	public void setTotalEmpWage(int totalEmpWage) {
		this.totalEmpWage = totalEmpWage;
	}
	public String toString() {
			return "Total employee wage for: " +company+ " is " +totalEmpWage;
		}
}

class EmpWage {
        
        public static final int IS_FULL_TIME = 1;
        public static final int IS_PART_TIME = 2;

		private int numOfCompany = 0;
		private CompanyEmpWage[] companyEmpWageArray;
		public EmpWage() {
		companyEmpWageArray = new CompanyEmpWage[5];
		}
		private void addCompanyEmpWage(String company, int empRatePerHr, int numberOfWorkingDays, int maxHrPerMonth) {
			companyEmpWageArray[numOfCompany] = new CompanyEmpWage(company, empRatePerHr, numberOfWorkingDays, maxHrPerMonth);

			numOfCompany++;

		}
		private void computeEmpWage() {
			for (int i=0; i<numOfCompany; i++) {
				companyEmpWageArray[i].setTotalEmpWage(this.computeEmpWage(companyEmpWageArray[i]));
				System.out.println(companyEmpWageArray[i]);
			}
		}




        private int computeEmpWage(CompanyEmpWage companyEmpWage) {
                

				int empHrs = 0;
				int totalEmpHrs = 0;
				int totalWorkingDays = 0;
				
				
				while (totalEmpHrs <= companyEmpWage.maxHrPerMonth && totalWorkingDays < companyEmpWage.numberOfWorkingDays) {

					totalWorkingDays++;
					double empCheck = Math.floor(Math.random() * 10) % 3;
					switch ((int)empCheck)
                        {
                                case IS_FULL_TIME :
                                        empHrs = 8;
                                        break;
                                case IS_PART_TIME :
                                        empHrs = 4;
                                        break;
                                default :
                                        empHrs = 0;

					}
					totalEmpHrs += empHrs;
					System.out.println(totalWorkingDays+" "+totalEmpHrs);
				}

					return totalEmpHrs * companyEmpWage.empRatePerHr;


        }


        public static void main(String[] args) {
        	EmpWage empWageBuilder = new EmpWage();
		empWageBuilder.addCompanyEmpWage("Deloitte", 50, 20, 100);
		empWageBuilder.addCompanyEmpWage("Cybage", 20, 20, 100);
		empWageBuilder.addCompanyEmpWage("Accenure", 100, 20, 100);
		empWageBuilder.computeEmpWage();
        }
}

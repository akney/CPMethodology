using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication3
{
    class DebtAsset : IAssetType
    {
        double principle, annualCouponRate, riskFreeRate;
        int numofyears, numofCouponPeriods_peryear;

        public DebtAsset(double Principle, double AnnualCouponrate, double Riskfreerate, int NumofCouponPeriods_peryear, int Numofyears) {
            principle = Principle;
            annualCouponRate = AnnualCouponrate;
            riskFreeRate = Riskfreerate;
            numofCouponPeriods_peryear = NumofCouponPeriods_peryear;
            numofyears = Numofyears;
        }

        public double evaluator()
        {
            double PV_coupon = 0;
            for (int i = 1; i < numofCouponPeriods_peryear * numofyears + 1; i++)
            {
                PV_coupon += principle * annualCouponRate / numofCouponPeriods_peryear * Math.Exp(-riskFreeRate * i / numofCouponPeriods_peryear);
            }

            return PV_coupon + principle / Math.Exp(-riskFreeRate * numofCouponPeriods_peryear * numofyears);
        }
    }
}

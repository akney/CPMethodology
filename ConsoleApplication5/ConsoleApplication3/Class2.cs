using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication3
{
    class EquityAsset : IAssetType
    {
        double dividend, growthrate, expectedstockreturn, shares;

        public EquityAsset(double dividend, double growthrate, double expectedstockreturn, double shares)
        {
            this.dividend = dividend;
            this.growthrate = growthrate;
            this.expectedstockreturn = expectedstockreturn;
            this.shares = shares;

        }

        public double evaluator()
        {
           if (growthrate < expectedstockreturn || dividend < 0) {
                throw new Exception();
            }

           return shares * (dividend / (growthrate - expectedstockreturn));
        }
    }
}

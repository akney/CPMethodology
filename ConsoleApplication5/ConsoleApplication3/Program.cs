using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication3
{
    class Program
    {
        static void Main(string[] args)
        {
            Asset[] assets = null;
            double totalValue = 0, totalvalue_20ys = 0;
        

            Console.WriteLine("Welcome to the portfolio estimator");
            Console.Write("How many assets do you have? ");
            int numAssets;
            
            if (int.TryParse(Console.ReadLine(), out numAssets))
                {
                    assets = new Asset[numAssets];
                }
           

            Console.WriteLine("Enter info about your assets: ");

            for (int i = 0; i < numAssets; i++)
            {
                Console.WriteLine("This is asset " + (i + 1));

                int choice =0;
                
                while (choice < 1 || choice > 3){
                    Console.WriteLine("Tell me what kind of asset it is: input the category number which it belong to");
                    Console.WriteLine("1 for equity, 2 for debt, 3 for housing");
                     choice = Convert.ToInt32(Console.ReadLine());
                }

                switch (choice)
                {
                    case 1:
                        Asset asset = Equity();
                        assets[i] = asset;
                        break;
                    case 2:
                        asset = Debt();
                        assets[i] = asset;
                        break;
                    case 3:
                        asset = House();
                        assets[i] = asset;
                        break;
                }

                Console.WriteLine("The value for this asset is " + assets[i].Result);
                totalValue += assets[i].Result;
                totalvalue_20ys += assets[i].Result_20ys;
            }

            //calculate the breakdown 
            for(int i = 0; i<numAssets; i++)
            {
                assets[i].Breakdown = assets[i].Result / totalValue;
                Console.WriteLine("The breakdown for asset " + (i + 1) + " is " + assets[i].Breakdown);
            }

            double expectedrate_return = totalvalue_20ys / totalValue;
            Console.WriteLine(" the expected rate of return in 20 years if you hold this portfolio is  " + expectedrate_return);
            Console.ReadKey();

        }

        static Asset Equity()
        {
            Console.WriteLine("You are evaluating equity");
            Console.WriteLine("Tell me how many shares do you have of the company ");
            double shares = Convert.ToDouble(Console.ReadLine());
            Console.WriteLine("Tell me the company current dividend");
            double dividend = Convert.ToDouble(Console.ReadLine());
            Console.WriteLine("Tell me the company growth rate");
            double growthrate = Convert.ToDouble(Console.ReadLine());
            Console.WriteLine("Tell me the expected stock return");
            double expectedstockreturn = Convert.ToDouble(Console.ReadLine());

           ;

            return new Asset(expectedstockreturn, new EquityAsset(dividend, growthrate, expectedstockreturn, shares));
            

        }

        static Asset Debt()
        {
            Console.WriteLine("You are evaluating debt");
            Console.WriteLine("Tell me what is the principle ");
            double principle = Convert.ToDouble(Console.ReadLine());
            Console.WriteLine("Tell me what is the Annual Coupon rate ");
            double annualcouponrate = Convert.ToDouble(Console.ReadLine());
            Console.WriteLine("Tell me what is the Riskfree rate ");
            double riskfreerate = Convert.ToDouble(Console.ReadLine());
            Console.WriteLine("Tell me how many coupon periods does one year have ");
            int numofCouponPeriods_peryear = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("Tell me how many years does this debt mature ");
            int numofyears = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("Tell me what the annual expected rate in 20 years ");
            double expectedrate = Convert.ToDouble(Console.ReadLine());

             
            return new Asset(expectedrate, new DebtAsset(principle, annualcouponrate, riskfreerate, numofCouponPeriods_peryear, numofyears));
;
        }

        static Asset House()
        {
            Console.WriteLine("You are evaluating house");
            Console.WriteLine("Tell me the area of the house ");
            double area_house = Convert.ToDouble(Console.ReadLine());
            Console.WriteLine("Tell me the price per square feet  of the house ");
            double price_persqfeet = Convert.ToDouble(Console.ReadLine());
            Console.WriteLine("Tell me how many bedrooms the house has ");
            int num_bedroom = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("Tell me how many restrooms the house has ");
            int num_restroom = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("Tell me what the annual expected rate in 20 years ");
            double expectedrate = Convert.ToDouble(Console.ReadLine());

            return new Asset(expectedrate, new HouseAsset(area_house, price_persqfeet, num_bedroom, num_restroom));
        }
    }
}


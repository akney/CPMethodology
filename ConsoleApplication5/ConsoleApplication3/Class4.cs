using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication3
{
    class HouseAsset : IAssetType
    {
        double area_house, price_persqfeet;
        int num_bedroom, num_restroom;

        public HouseAsset(double area_house, double price_persqfeet, int num_bedroom, int num_restroom) {
            this.area_house = area_house;
            this.price_persqfeet = price_persqfeet;
            this.num_bedroom = num_bedroom;
            this.num_restroom = num_restroom;
        }

        public double evaluator()
        {
            if (area_house < 0)
            {
                throw new Exception();
            }
            
            return area_house * price_persqfeet * Math.Sqrt(Convert.ToDouble(num_bedroom + num_restroom));           
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication3
{
    class Asset 
    {
        private IAssetType assetType;
        private double result;
        private double breakdown;
        private double expectedrate;
        private double result_20ys;

        public Asset(double expectedrate, IAssetType type)
        {
            this.expectedrate = expectedrate;
            this.assetType = type;
            result = assetType.evaluator();
            result_20ys = Math.Pow((1 + expectedrate), 20) * result;


        }
        public String AssetType{ get; set; }
        public double Result { get; }
        public double Breakdown { get; set; }
        public double Expectedrate { get; }
        public double Result_20ys{ get; }
    }
}

using System;
using System.Collections.Generic;

#nullable disable

namespace M9_W3_Assignment1_2_NorthWind.data
{
    public partial class SalesTotalsByAmount
    {
        public decimal? SaleAmount { get; set; }
        public int OrderId { get; set; }
        public string CompanyName { get; set; }
        public DateTime? ShippedDate { get; set; }
    }
}

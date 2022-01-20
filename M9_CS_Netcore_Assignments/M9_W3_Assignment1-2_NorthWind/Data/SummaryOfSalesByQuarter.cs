using System;
using System.Collections.Generic;

#nullable disable

namespace M9_W3_Assignment1_2_NorthWind.data
{
    public partial class SummaryOfSalesByQuarter
    {
        public DateTime? ShippedDate { get; set; }
        public int OrderId { get; set; }
        public decimal? Subtotal { get; set; }
    }
}

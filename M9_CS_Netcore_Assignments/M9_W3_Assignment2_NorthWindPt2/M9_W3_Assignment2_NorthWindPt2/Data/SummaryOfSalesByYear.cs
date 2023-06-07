using System;
using System.Collections.Generic;

#nullable disable

namespace M9_W3_Assignment2_NorthWindPt2.data
{
    public partial class SummaryOfSalesByYear
    {
        public DateTime? ShippedDate { get; set; }
        public int OrderId { get; set; }
        public decimal? Subtotal { get; set; }
    }
}

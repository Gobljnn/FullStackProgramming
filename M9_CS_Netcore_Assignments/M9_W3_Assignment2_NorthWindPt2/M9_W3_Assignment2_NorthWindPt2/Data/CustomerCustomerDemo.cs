using System;
using System.Collections.Generic;

#nullable disable

namespace M9_W3_Assignment2_NorthWindPt2.data
{
    public partial class CustomerCustomerDemo
    {
        public string CustomerId { get; set; }
        public string CustomerTypeId { get; set; }

        public virtual Customer Customer { get; set; }
        public virtual CustomerDemographic CustomerType { get; set; }
    }
}

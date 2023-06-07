using System;
using System.Collections.Generic;

#nullable disable

namespace M9_W3_Assignment2_NorthWindPt2.data
{
    public partial class EmployeeTerritory
    {
        public int EmployeeId { get; set; }
        public string TerritoryId { get; set; }

        public virtual Employee Employee { get; set; }
        public virtual Territory Territory { get; set; }
    }
}

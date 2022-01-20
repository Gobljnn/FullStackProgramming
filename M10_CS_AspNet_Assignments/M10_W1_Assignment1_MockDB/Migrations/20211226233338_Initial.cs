using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Migrations;

namespace M10_W1_Assignment1_MockDB.Migrations
{
    public partial class Initial : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AlterDatabase()
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.CreateTable(
                name: "Courses",
                columns: table => new
                {
                    courseID = table.Column<int>(type: "int", nullable: false)
                        .Annotation("MySql:ValueGenerationStrategy", MySqlValueGenerationStrategy.IdentityColumn),
                    courseName = table.Column<string>(type: "longtext", nullable: true)
                        .Annotation("MySql:CharSet", "utf8mb4"),
                    courseDesc = table.Column<string>(type: "longtext", nullable: true)
                        .Annotation("MySql:CharSet", "utf8mb4")
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Courses", x => x.courseID);
                })
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.CreateTable(
                name: "Instructors",
                columns: table => new
                {
                    insID = table.Column<int>(type: "int", nullable: false)
                        .Annotation("MySql:ValueGenerationStrategy", MySqlValueGenerationStrategy.IdentityColumn),
                    firstName = table.Column<string>(type: "longtext", nullable: true)
                        .Annotation("MySql:CharSet", "utf8mb4"),
                    lastName = table.Column<string>(type: "longtext", nullable: true)
                        .Annotation("MySql:CharSet", "utf8mb4"),
                    email = table.Column<string>(type: "longtext", nullable: true)
                        .Annotation("MySql:CharSet", "utf8mb4"),
                    courseID = table.Column<int>(type: "int", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Instructors", x => x.insID);
                    table.ForeignKey(
                        name: "FK_Instructors_Courses_courseID",
                        column: x => x.courseID,
                        principalTable: "Courses",
                        principalColumn: "courseID",
                        onDelete: ReferentialAction.Restrict);
                })
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.CreateTable(
                name: "Students",
                columns: table => new
                {
                    stuID = table.Column<int>(type: "int", nullable: false)
                        .Annotation("MySql:ValueGenerationStrategy", MySqlValueGenerationStrategy.IdentityColumn),
                    firstName = table.Column<string>(type: "longtext", nullable: true)
                        .Annotation("MySql:CharSet", "utf8mb4"),
                    lastName = table.Column<string>(type: "longtext", nullable: true)
                        .Annotation("MySql:CharSet", "utf8mb4"),
                    email = table.Column<string>(type: "longtext", nullable: true)
                        .Annotation("MySql:CharSet", "utf8mb4"),
                    phoneNum = table.Column<long>(type: "bigint", nullable: false),
                    courseID = table.Column<int>(type: "int", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Students", x => x.stuID);
                    table.ForeignKey(
                        name: "FK_Students_Courses_courseID",
                        column: x => x.courseID,
                        principalTable: "Courses",
                        principalColumn: "courseID",
                        onDelete: ReferentialAction.Restrict);
                })
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.InsertData(
                table: "Courses",
                columns: new[] { "courseID", "courseDesc", "courseName" },
                values: new object[,]
                {
                    { 2, "CSS Desc", "CSS" },
                    { 3, "Java Desc", "JAVA" },
                    { 1, "HTML Desc", "HTML" },
                    { 4, "SQL Desc", "SQL" }
                });

            migrationBuilder.InsertData(
                table: "Instructors",
                columns: new[] { "insID", "courseID", "email", "firstName", "lastName" },
                values: new object[,]
                {
                    { 3, 2, "VJ@email.com", "Vilhelmo", "Joiner" },
                    { 4, 3, "HR@email.com", "Hildingr", "Reis" },
                    { 1, 1, "ES@email.com", "Ediz", "Seeger" },
                    { 2, 4, "YM@email.com", "Yemima", "Morce" }
                });

            migrationBuilder.InsertData(
                table: "Students",
                columns: new[] { "stuID", "courseID", "email", "firstName", "lastName", "phoneNum" },
                values: new object[,]
                {
                    { 4, 2, "LK@email.com", "Line", "Krüger", 7806456789L },
                    { 2, 3, "JK@email.com", "Jep", "Khachaturian", 780123456L },
                    { 3, 1, "PB@email.com", "Paulina", "Biancardi", 78023456L },
                    { 1, 4, "GM@email.com", "Gijsbert", "Marini", 7801234567L }
                });

            migrationBuilder.CreateIndex(
                name: "IX_Instructors_courseID",
                table: "Instructors",
                column: "courseID");

            migrationBuilder.CreateIndex(
                name: "IX_Students_courseID",
                table: "Students",
                column: "courseID");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Instructors");

            migrationBuilder.DropTable(
                name: "Students");

            migrationBuilder.DropTable(
                name: "Courses");
        }
    }
}

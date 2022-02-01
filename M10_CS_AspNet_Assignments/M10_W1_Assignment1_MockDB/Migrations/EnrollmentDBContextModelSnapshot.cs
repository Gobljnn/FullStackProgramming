﻿// <auto-generated />
using System;
using M10_W1_Assignment1_MockDB.Data;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Storage.ValueConversion;

namespace M10_W1_Assignment1_MockDB.Migrations
{
    [DbContext(typeof(EnrollmentDBContext))]
    partial class EnrollmentDBContextModelSnapshot : ModelSnapshot
    {
        protected override void BuildModel(ModelBuilder modelBuilder)
        {
#pragma warning disable 612, 618
            modelBuilder
                .HasAnnotation("Relational:MaxIdentifierLength", 64)
                .HasAnnotation("ProductVersion", "5.0.10");

            modelBuilder.Entity("M10_W1_Assignment1_MockDB.Models.Course", b =>
                {
                    b.Property<int>("courseID")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int");

                    b.Property<string>("courseDesc")
                        .HasColumnType("longtext");

                    b.Property<string>("courseName")
                        .HasColumnType("longtext");

                    b.HasKey("courseID");

                    b.ToTable("Courses");

                    b.HasData(
                        new
                        {
                            courseID = 2,
                            courseDesc = "CSS Desc",
                            courseName = "CSS"
                        },
                        new
                        {
                            courseID = 3,
                            courseDesc = "Java Desc",
                            courseName = "JAVA"
                        },
                        new
                        {
                            courseID = 1,
                            courseDesc = "HTML Desc",
                            courseName = "HTML"
                        },
                        new
                        {
                            courseID = 4,
                            courseDesc = "SQL Desc",
                            courseName = "SQL"
                        });
                });

            modelBuilder.Entity("M10_W1_Assignment1_MockDB.Models.Instructor", b =>
                {
                    b.Property<int>("insID")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int");

                    b.Property<int?>("courseID")
                        .HasColumnType("int");

                    b.Property<string>("email")
                        .HasColumnType("longtext");

                    b.Property<string>("firstName")
                        .HasColumnType("longtext");

                    b.Property<string>("lastName")
                        .HasColumnType("longtext");

                    b.HasKey("insID");

                    b.HasIndex("courseID");

                    b.ToTable("Instructors");

                    b.HasData(
                        new
                        {
                            insID = 1,
                            courseID = 1,
                            email = "ES@email.com",
                            firstName = "Ediz",
                            lastName = "Seeger"
                        },
                        new
                        {
                            insID = 2,
                            courseID = 4,
                            email = "YM@email.com",
                            firstName = "Yemima",
                            lastName = "Morce"
                        },
                        new
                        {
                            insID = 3,
                            courseID = 2,
                            email = "VJ@email.com",
                            firstName = "Vilhelmo",
                            lastName = "Joiner"
                        },
                        new
                        {
                            insID = 4,
                            courseID = 3,
                            email = "HR@email.com",
                            firstName = "Hildingr",
                            lastName = "Reis"
                        });
                });

            modelBuilder.Entity("M10_W1_Assignment1_MockDB.Models.Student", b =>
                {
                    b.Property<int>("stuID")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int");

                    b.Property<int?>("courseID")
                        .HasColumnType("int");

                    b.Property<string>("email")
                        .HasColumnType("longtext");

                    b.Property<string>("firstName")
                        .HasColumnType("longtext");

                    b.Property<string>("lastName")
                        .HasColumnType("longtext");

                    b.Property<long>("phoneNum")
                        .HasColumnType("bigint");

                    b.HasKey("stuID");

                    b.HasIndex("courseID");

                    b.ToTable("Students");

                    b.HasData(
                        new
                        {
                            stuID = 1,
                            courseID = 4,
                            email = "GM@email.com",
                            firstName = "Gijsbert",
                            lastName = "Marini",
                            phoneNum = 7801234567L
                        },
                        new
                        {
                            stuID = 2,
                            courseID = 3,
                            email = "JK@email.com",
                            firstName = "Jep",
                            lastName = "Khachaturian",
                            phoneNum = 780123456L
                        },
                        new
                        {
                            stuID = 3,
                            courseID = 1,
                            email = "PB@email.com",
                            firstName = "Paulina",
                            lastName = "Biancardi",
                            phoneNum = 78023456L
                        },
                        new
                        {
                            stuID = 4,
                            courseID = 2,
                            email = "LK@email.com",
                            firstName = "Line",
                            lastName = "Krüger",
                            phoneNum = 7806456789L
                        });
                });

            modelBuilder.Entity("M10_W1_Assignment1_MockDB.Models.Instructor", b =>
                {
                    b.HasOne("M10_W1_Assignment1_MockDB.Models.Course", "Course")
                        .WithMany()
                        .HasForeignKey("courseID");

                    b.Navigation("Course");
                });

            modelBuilder.Entity("M10_W1_Assignment1_MockDB.Models.Student", b =>
                {
                    b.HasOne("M10_W1_Assignment1_MockDB.Models.Course", "Course")
                        .WithMany()
                        .HasForeignKey("courseID");

                    b.Navigation("Course");
                });
#pragma warning restore 612, 618
        }
    }
}
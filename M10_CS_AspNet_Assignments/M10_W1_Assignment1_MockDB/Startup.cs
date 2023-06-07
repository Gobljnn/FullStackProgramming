using M10_W1_Assignment1_MockDB.Data;
using M10_W1_Assignment1_MockDB.Data.Interface;
using M10_W1_Assignment1_MockDB.Data.MockRepos;
using M10_W1_Assignment1_MockDB.Data.SqlRepos;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.HttpsPolicy;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace M10_W1_Assignment1_MockDB {
    public class Startup {
        public Startup(IConfiguration configuration) {
            Configuration = configuration;
        }

        public IConfiguration Configuration { get; }

        // This method gets called by the runtime. Use this method to add services to the container.
        public void ConfigureServices(IServiceCollection services) {
            /* Create cs and vs, then add the type of db server fnc body
             * Following these steps in package manager console add the following lines of syntax:
             * 
             * --"add-migration Initial" 
             * 
             * Name of migrations = Initial
             * Error might be given if no primary/foreign key data is given in models
             * 
             * --"update-database"
             * 
             *Schema in db should be created, might need to refresh
             * 
             */

            //getting access to connection string for db
            var cs = Configuration.GetConnectionString("Default"); //name of connection string in appsetting.json

            //server version (sql)
            var sv = ServerVersion.AutoDetect(cs);

            //type of db server
            services.AddDbContext<EnrollmentDBContext>(options => { //error function method-provide options
                options.UseMySql(cs, sv);
            });

            services.AddControllersWithViews();

            //using mock repository
            //services.AddScoped<IInstructorRepo, MockInstructorRepo>();
            //services.AddScoped<ICourseRepo, MockCourseRepo>();
            //services.AddScoped<IStudentRepo, MockStudentRepo>();

            //using actual db
            services.AddScoped<IInstructorRepo, SqlInstructorRepo>();
            services.AddScoped<ICourseRepo, SqlCourseRepo>();
            services.AddScoped<IStudentRepo, SqlStudentRepo>();
        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, IWebHostEnvironment env) {
            if (env.IsDevelopment()) {
                app.UseDeveloperExceptionPage();
            }
            else {
                app.UseExceptionHandler("/Home/Error");
                // The default HSTS value is 30 days. You may want to change this for production scenarios, see https://aka.ms/aspnetcore-hsts.
                app.UseHsts();
            }
            app.UseHttpsRedirection();
            app.UseStaticFiles();

            app.UseRouting();

            app.UseAuthorization();

            app.UseEndpoints(endpoints => {
                endpoints.MapControllerRoute(
                    name: "default",
                    pattern: "{controller=Home}/{action=Index}/{id?}");
            });
        }
    }
}

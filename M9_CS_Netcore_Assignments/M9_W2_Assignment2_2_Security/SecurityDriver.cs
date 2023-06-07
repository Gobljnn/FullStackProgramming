using System;
using static System.Console;
using static System.Convert;
using System.IO;
using static System.IO.Path;
using static System.Environment;
using System.Xml.Serialization;
//using Packt.Shared;
using System.Security.Cryptography;
using System.Xml;
//System.Security.Cryptography.RandomNumberGenerator;

namespace M9_W2_Assignment2_2_Security {

    public class Person {
        public string Name {
            get; /*{ return FirstName; }*/
            set; /*{ FirstName = value;}*/
        }

        public string CreditC { get; set; }
        public string Password { get; set; }

    }

    public class decodeItems {
        [XmlElement(Namespace = "Name")]
        public string Name;
        [XmlElement(Namespace = "CreditC")]
        public string CreditC;
        [XmlElement(Namespace = "Password")]
        public decimal Passsword;
    }

    //private void DeserializedObject(string filename) {

    //}


    class SecurityDriver {
        static void Main(string[] args) {


            /***********************************************************************************************************************/
            Person peep = new Person { Name = "Dean Bob", CreditC = "1234-5678-9012-3456", Password = "Pa$$w0rd" };

            var contentName = peep.Name;
            var contentCC = peep.CreditC;
            var contentPP = peep.Password;
            string key = "yRGEbyQNK742069n";

            Encryption encrypt = new Encryption();
            peep.Name = encrypt.EncryptString(contentName, key);
            peep.CreditC = encrypt.EncryptString(contentCC, key);
            peep.Password = encrypt.EncryptString(contentPP, key);

            contentName = "";
            contentCC = "";
            contentPP = "";

            //Create file to write to
            string path = Combine(CurrentDirectory, "ProtectedXml.xml");

            //serialize Person 

            var xs = new XmlSerializer(typeof(Person));


            using (FileStream stream = File.Create(path)) {
                xs.Serialize(stream, peep);
            }

            //deserializing process

            using (FileStream xmlLoad = File.Open(path, FileMode.Open)) {
                var loadedShapesXml = (Person)xs.Deserialize(xmlLoad);
            }

            WriteLine("*********** Encrypted Info ***********");

            //Console.WriteLine(File.ReadAllText(path));

            //create salt
            //using created saltandhash class -- ***************

            SaltAndHash sandh = new SaltAndHash();
            RNGCryptoServiceProvider rngSalt = new RNGCryptoServiceProvider();
            byte[] salt = new byte[16];
            rngSalt.GetBytes(salt);
            string randSalt = ToBase64String(salt);

            //load xml document
            XmlDocument document = new XmlDocument();
            document.Load(path);

            //change password and cc elements in XML file
            XmlElement passwordEle = document.GetElementsByTagName("Password")[0] as XmlElement;
            passwordEle.InnerText = sandh.SaltAndHashPassword(peep.Password, randSalt);

            XmlElement creditCEle = document.GetElementsByTagName("CreditC")[0] as XmlElement;
            creditCEle.InnerText = peep.CreditC;

            Console.WriteLine(File.ReadAllText(path));
            WriteLine("********** Password has been Salt and Hashed **********");



        }
    }
}


using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections.Generic;
using System.Security.Cryptography;
using System.Security.Principal;
using System.IO;

namespace M9_W2_Assignment2_2_Security {
    class Encryption {
        public string EncryptString(string text, string keyString) { // taking 2 parameters from SecDriver
            var key = Encoding.UTF8.GetBytes(keyString);

            using (var aesAlg = Aes.Create()) {
                using (var encryptor = aesAlg.CreateEncryptor(key, aesAlg.IV)) {
                    using (var msEncrypt = new MemoryStream()) {
                        using (var csEncrypt = new CryptoStream(msEncrypt, encryptor, CryptoStreamMode.Write))
                        using (var swEncrypt = new StreamWriter(csEncrypt)) {
                            swEncrypt.Write(text);
                        }

                        var iv = aesAlg.IV;

                        var decryptedContent = msEncrypt.ToArray();

                        var result = new byte[iv.Length + decryptedContent.Length];

                        Buffer.BlockCopy(iv, 0, result, 0, iv.Length);
                        Buffer.BlockCopy(decryptedContent, 0, result, iv.Length, decryptedContent.Length);

                        return Convert.ToBase64String(result);
                    }
                }
            }
        }
    }
}

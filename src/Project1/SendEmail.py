import smtplib, ssl, sys
from smtplib import SMTPAuthenticationError
def main():
    try:
        email = sys.argv[1]
        password = sys.argv[2]
        receiving_email = sys.argv[3]
        f = open("FinalList.txt", "r")
        x = f.read()
        port = 587  # For starttls
        smtp_server = "smtp.gmail.com"
        message = """
        Subject: Lista de Mercado
    
        """
        message += x
    
        context = ssl.create_default_context()
        with smtplib.SMTP(smtp_server, port) as server:
            server.starttls(context=context)
            server.login(email, password)
            server.sendmail(email, receiving_email, message)
        print("Success")
        return 0
    except SMTPAuthenticationError:
        print("Fail")
    
main()
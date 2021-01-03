import smtplib, ssl

f = open("C:/Users/sadra/ICS_45J/LaLista/FinalList.txt", "r")
x = f.read()

port = 587  # For starttls
smtp_server = "smtp.gmail.com"
sender_email = input("Gmail: ")
password = input("Password: ")
receiver_email = input("Receiving Email: ")
message = """\
Subject: Lista de Mercado!

"""
message += x

context = ssl.create_default_context()
with smtplib.SMTP(smtp_server, port) as server:
    server.starttls(context=context)
    server.login(sender_email, password)
    server.sendmail(sender_email, receiver_email, message)
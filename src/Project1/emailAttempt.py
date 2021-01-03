import smtplib, ssl
#print("HOLA")
#f = open(FinalList)
f = open("C:/Users/sadra/ICS_45J/LaLista/FinalList.txt", "r")
x = f.read()

port = 587  # For starttls
smtp_server = "smtp.gmail.com"
sender_email = "turkeysandwich0@gmail.com"
receiver_email = "turkeysandwich0@gmail.com"
password = "Sadrach2"
message = """\
Subject: Hi there

"""
message += x

context = ssl.create_default_context()
with smtplib.SMTP(smtp_server, port) as server:
    server.ehlo()  # Can be omitted
    server.starttls(context=context)
    server.ehlo()  # Can be omitted
    server.login(sender_email, password)
    server.sendmail(sender_email, receiver_email, message)
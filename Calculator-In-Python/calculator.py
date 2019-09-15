#Import library
import sys
from tkinter import *

#Function to add digit or operation
def btnClick(numbers):
    global operator
    operator = operator+ str(numbers)
    text_input.set(operator)

#Function to clear Display
def btnClearDisplay():
    global operator
    operator=""
    text_input.set("")

# Function to find output and display it
def btnequalsto():
    global operator
    sumup = str(eval(operator))
    text_input.set(sumup)
    operator = ""

# Creation of Window Display
cal = Tk()
cal.title("CALCULATOR v0.0.8")
operator=""
text_input=StringVar()

# Display Text 
txtdisplay= Entry(cal , font=('arial', 20, 'bold'),textvariable=text_input, bd=35, insertwidth=5, bg='powder blue', justify='right').grid(columnspan=4)

# Button for First Row
btn7=Button(cal , padx=16,pady=9,bd=8, fg="black",font=('arial',20,'bold'),command=lambda:btnClick(7),text='7').grid(row=1,column=0)

btn8=Button(cal , padx=16,pady=9 ,bd=8, fg="black",font=('arial',20,'bold'),command=lambda:btnClick(8),text='8').grid(row=1,column=1)

btn9=Button(cal , padx=16,pady=9 ,bd=8, fg="black",font=('arial',20,'bold'),command=lambda:btnClick(9),text='9').grid(row=1,column=2)

divide=Button(cal , padx=19 ,pady=9,bd=8, fg="black",font=('arial',20,'bold'),command=lambda:btnClick("/"),text='/').grid(row=1,column=3)

# Button for Second Row
btn4=Button(cal , padx=16,pady=9 ,bd=8, fg="black",font=('arial',20,'bold'),command=lambda:btnClick(4),text='4').grid(row=2,column=0)

btn5=Button(cal , padx=16 ,pady=9,bd=8, fg="black",font=('arial',20,'bold'),command=lambda:btnClick(5),text='5').grid(row=2,column=1)

btn6=Button(cal , padx=16 ,pady=9,bd=8, fg="black",font=('arial',20,'bold'),command=lambda:btnClick(6),text='6').grid(row=2,column=2)

multiply=Button(cal , padx=19,pady=9,bd=8, fg="black",font=('arial',20,'bold'),command=lambda:btnClick("*"),text='*').grid(row=2,column=3)

# Button for Third Row
btn1=Button(cal , padx=16,pady=9 ,bd=8, fg="black",font=('arial',20,'bold'),command=lambda:btnClick(1),text='1').grid(row=3,column=0)

btn2=Button(cal , padx=16 ,pady=9,bd=8, fg="black",font=('arial',20,'bold'),command=lambda:btnClick(2),text='2').grid(row=3,column=1)

btn3=Button(cal , padx=16 ,pady=9,bd=8, fg="black",font=('arial',20,'bold'),command=lambda:btnClick(3),text='3').grid(row=3,column=2)

sub=Button(cal , padx=19 ,pady=9,bd=8, fg="black",font=('arial',20,'bold'),command=lambda:btnClick("-"),text='-').grid(row=3,column=3)

# Button for Fourth Row
btn0=Button(cal , padx=16,pady=9 ,bd=8, fg="black",font=('arial',20,'bold'),command=lambda:btnClick(0),text='0').grid(row=4,column=0)

clear=Button(cal , padx=16,pady=9 ,bd=8, fg="black",font=('arial',20,'bold'),text='C',command=btnClearDisplay).grid(row=4,column=1)

eqaul=Button(cal , padx=16,pady=9 ,bd=8, fg="black",font=('arial',20,'bold'),command=btnequalsto,text='=').grid(row=4,column=2)

add=Button(cal , padx=16 ,pady=9,bd=8, fg="black",font=('arial',20,'bold'),command=lambda:btnClick("+"),text='+').grid(row=4,column=3)

cal.mainloop()

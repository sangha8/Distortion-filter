# -*- coding: utf-8 -*-
"""
Created on Sat Nov 17 14:17:31 2018

@author: DELL
"""
#importing libraries
import pandas as pd
import matplotlib.pyplot as plt 
# reading the original signal's dat file
data = pd.read_csv("mysteryTones.dat", header=None, delimiter=r"\s+")
#Storing time values in xlist and amplitude values in ylist 
x = data[0]
y = data[1]
xlist = []
ylist = []
for i in range(0,int(len(x))):
   xlist.append(float(x.iloc[i]))
   ylist.append(float(y.iloc[i]))   
   
#plotting line graph using values stored in xlist and ylist for the time period of 0.0000s to 0.0200s
fig = plt.figure(figsize=(12,3))
plt.xlabel('time')
plt.ylabel('amplitude')
plt.plot(xlist,ylist)
plt.axis([0.00,0.020,-1,1])
plt.grid()
plt.show()



# reading the filtered signal's dat file
data = pd.read_csv("fo.dat", header=None, delimiter=r"\s+")
#Storing time values in xlist and amplitude values in ylist 
x = data[0]
y = data[1]
xlist = []
ylist = []
for i in range(0,int(len(x))):
   xlist.append(float(x.iloc[i]))
   ylist.append(float(y.iloc[i]))   

#plotting line graph using values stored in xlist and ylist for the time period of 0.0000s to 0.0200s
fig = plt.figure(figsize=(12,3))
plt.xlabel('time')
plt.ylabel('amplitude')
plt.plot(xlist,ylist)
plt.axis([0.00,0.020,-1,1])
plt.grid()
plt.show()

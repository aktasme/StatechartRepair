# Import libraries
import matplotlib.pyplot as plt
import numpy as np
import pandas as pd

directory = '../../results/' 
fileName = 'P2'
dataExtension = '.csv'
figureExtension = '.jpg'
fileString = directory + fileName + dataExtension
figureString = directory + fileName + figureExtension

usecols = ['#N', '#S', '#C', '#T', '#E', '#I']
dataFrame = pd.read_csv (fileString, sep=';', usecols=usecols)
print(dataFrame)

dataFrame.boxplot(showfliers=False)

plt.savefig(figureString)
plt.show()

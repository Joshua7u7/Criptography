def Dump(Public_Key,path):
	import pickle
	file = open(path,'wb')
	file.write(Public_Key)
	file.close()

def Load(path):
	import pickle
	file = open(path,'rb')
	key=file.read()
	file.close()
	key = key.encode()
	return key

def Hola(cad):
	print(cad)	
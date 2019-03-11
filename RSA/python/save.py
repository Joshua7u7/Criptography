def Dump(Public_Key,path):
	import pickle
	file = open(path,'wb')
	file.write(Public_Key)
	file.close()
	print(type(Public_Key))
	print(Public_Key)

def Load(path):
	import pickle
	file = open(path,'rb')
	key=file.read()
	file.close()
	print(type(key))
	print(key)
	key = key.encode()
	print(type(key))
	print(key)
	return key

def Hola(cad):
	print(cad)	
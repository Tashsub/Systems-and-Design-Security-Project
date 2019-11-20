/*package database;

@user = SQLite3::Database.open "database/userDb.sqlite"

def addAccount(title, forename, surname, university, loginID, password) 
	@user.execute %{INSERT INTO User VALUES('#{title}', '#{forename}', '#{surname}', '#{university}', '#{loginID}', '#{password}'}
end

def getTitle(loginID) 
	return (@user.execute "SELECT title FROM User WHERE loginID LIKE '#{loginID}'") 
end

def getForename(loginID) 
	return (@user.execute "SELECT forename FROM User WHERE loginID LIKE '#{loginID}'") 
end

def getSurname(loginID) 
	return (@user.execute "SELECT surname FROM User WHERE loginID LIKE '#{loginID}'") 
end

def getUniversity(loginID) 
	return (@user.execute %{SELECT university FROM User WHERE loginID LIKE '#{loginID}'}) 
end

def getPKLoginID(forename, surname) 
	return (@user.execute %{SELECT PKLoginID FROM User WHERE forename LIKE '#{forename}' && surname LIKE '#{surname}') 
end

def getPassword(loginID) 
	return (@user.execute %{SELECT password FROM User WHERE loginID LIKE '#{loginID}'}) 
end

def updatePassword(loginID, password) 
	@user.execute %{UPDATE User SET password = '#{password}' WHERE loginID LIKE '#{loginID}'}
end

def isAuthor(loginID)
	return (@user.execute %{SELECT isAuthor FROM User WHERE loginID LIKE '#{loginID}'})
end 

def isEditor(loginID)
	return (@user.execute %{SELECT isEditor FROM User WHERE loginID LIKE '#{loginID}'})
end 

def isReviewer(loginID)
	return (@user.execute %{SELECT isReviewer FROM User WHERE loginID LIKE '#{loginID}'})
end */
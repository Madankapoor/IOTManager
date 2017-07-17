
Package List and Classes

	Package List and Classes

	views
		company:companyusers,companysensors,addcompany
		navbar:nonauthnavbar,authnavbar
		sensor:addsensor,simulate,graph
		user:login,register
		main:final

	global.coda.iotmanager.models
		
		
		User - Object used to represent User

		Sensor

		Company

		CompanyHeader


	global.coda.iotmanager.controllers

		sensor

		session

		company

	global.coda.iotmanager.services.intf
		Session

		Sensor

		CompanyList

	global.coda.iotmanager.services.impl
		Session

		Sensor

		CompanyList
	global.coda.iotmanager.dataaccesslayer.intf
		Session

		Sensor

		CompanyList
	global.coda.iotmanager.dataaccesslayer.impl

		Session

		Sensor

		CompanyList

	global.coda.iotmanager.utils
		SQLSTATEMENTS

		DataBaseHelper
		
		Mailer

		Trigger
		




MyDoubts:

In Swing and Java Layers

How to pass exceptions between layers ?should Exceptions be handled in DAL or it should be passed to service and handled ?

how to could be make error handling easy ?

How Much Data Transfer is allowed between layers ?

How to optmize the openning and closing connection , which would be the best appraoch for a database util ?

how much logs should we generate ?


how to understand gradle ?

how to automate using gradle ?

how to optmize tomcat natively ?

how to handle crsf and xss scripting errors ?

how to prevent sql injection or pentration ?


should we write our own eclipse pulgins ?



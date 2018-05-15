package logParser.common

object TreatLog {

case class LogRecord(slab : String , viewmode : String, zoom : String)

/*
 * Transormer une ligne de log en un objet LogRecord
 */
def parseLogLine(log: String): LogRecord = {

		val logArray = log.split("/") 
				if (logArray.size < 9 || logArray(3).trim() != "slab") {
					LogRecord("Empty","Empty","Empty")
				} else {
					LogRecord(logArray(3).trim(), logArray(4).trim(),logArray(6).trim())
				}
}

/*
 * Concaténer les elements d'une liste en une chaine de caractère
 */
def concatElement(zoomList : List[String]) : String={
		var zoom = ""
				for (e <- zoomList) zoom = zoom+e+","
				zoom = zoom.substring(0,zoom.length-1)
				zoom
}

}
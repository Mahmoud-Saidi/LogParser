package logParser.core

import scala.io.Source
import logParser.common.TreatLog

object PrintResult1 {
  
/*
 * Affichage d'une ligne contenant un viewmode,le nombre d’occurrences du viewmode
 */
def printSingleLine(logRecord : TreatLog.LogRecord) = {
		val vmode = viewmode

				if (logRecord.slab == "slab"){
					logRecord.viewmode match {   
					case `vmode` => number = number +1 
					case _ => {
						if (viewmode != "") println(viewmode+"\t"+number)

						viewmode = logRecord.viewmode
						number = 1
					}
					}
				}
}

var viewmode = ""
var number = 0

def main(args: Array[String]) {
  //Lecture du fichier 
	val bufferedSource = Source.fromFile(args(0))
	
	//Traitement des ligne de log un par un 
	for (line <- bufferedSource.getLines) {
				val logRecord = TreatLog.parseLogLine(line)
				printSingleLine(logRecord)

			}
	
	//traitement de la dernière ligne 
	if (viewmode != "") println(viewmode+"\t"+number)
	
	//Fermeture du Buffer
	bufferedSource.close
}

}
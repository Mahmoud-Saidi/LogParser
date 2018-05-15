package logParser.core

import scala.io.Source
import logParser.common.TreatLog
import scala.collection.mutable.ListBuffer

object PrintResult2 {

/*
 * Affichage d'une ligne contenant un viewmode,le nombre d’occurrences du viewmode et la liste des niveaux de zooms	
 */
def printSingleLine(logRecord : TreatLog.LogRecord) = {
			val vmode = viewmode

					if (logRecord.slab == "slab"){
						logRecord.viewmode match {   
						case `vmode` => {
							number = number +1
									zoomBuffer += logRecord.zoom
						}
						case _ => {
							if (viewmode != "") {
								val zoom = TreatLog.concatElement(zoomBuffer.toList.toSet.toList)
										println(viewmode+"\t"+number+"\t"+zoom)
										zoomBuffer.clear()
							}

							viewmode = logRecord.viewmode
									number = 1
									zoomBuffer += logRecord.zoom
						}
						}
					}
	}

var viewmode = ""
var number = 0
val zoomBuffer = ListBuffer.empty[String]

def main(args: Array[String]) {
    //Lecture du fichier 
		val bufferedSource = Source.fromFile(args(0))
		
		//Traitement des ligne de log un par un 
				for (line <- bufferedSource.getLines) {
					val logRecord = TreatLog.parseLogLine(line)
							printSingleLine(logRecord)
				}
		
		//traitement de la dernière ligne 
		if (viewmode != "") {
			val zoom = TreatLog.concatElement(zoomBuffer.toList.toSet.toList)
					println(viewmode+"\t"+number+"\t"+zoom)
					zoomBuffer.clear()
		}
		
		//Fermeture du Buffer
		bufferedSource.close
	}


}
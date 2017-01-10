/*
 * Copyright 2016 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * License Terms
 */

 
package gov.nasa.jpl.imce.omf.schema.tables

import scala.annotation.meta.field
import scala.scalajs.js.annotation.JSExport
import scala._
import scala.Predef._

/**
  * @param uuid[1,1]
  * @param designatedConceptUUID[1,1]
  * @param designationTerminologyGraphUUID[1,1]
  */
@JSExport
case class ConceptDesignationTerminologyAxiom
(
  @(JSExport @field) uuid: UUID,
  @(JSExport @field) designatedConceptUUID: UUID,
  @(JSExport @field) designationTerminologyGraphUUID: UUID
) {
  override val hashCode
  : scala.Int 
  = (uuid, designatedConceptUUID, designationTerminologyGraphUUID).##
  
  override def equals(other: scala.Any): scala.Boolean = other match {
  	case that: ConceptDesignationTerminologyAxiom =>
  	  (this.uuid == that.uuid) &&
  	  (this.designatedConceptUUID == that.designatedConceptUUID) &&
  	  (this.designationTerminologyGraphUUID == that.designationTerminologyGraphUUID)
    case _ =>
      false
  }
  
}

@JSExport
object ConceptDesignationTerminologyAxiomHelper {

  val TABLE_JSON_FILENAME 
  : scala.Predef.String 
  = "ConceptDesignationTerminologyAxioms.json"
  
  implicit val w
  : upickle.default.Writer[ConceptDesignationTerminologyAxiom]
  = upickle.default.macroW[ConceptDesignationTerminologyAxiom]

  @JSExport
  def toJSON(c: ConceptDesignationTerminologyAxiom)
  : String
  = upickle.default.write(expr=c, indent=0)

  implicit val r
  : upickle.default.Reader[ConceptDesignationTerminologyAxiom]
  = upickle.default.macroR[ConceptDesignationTerminologyAxiom]

  @JSExport
  def fromJSON(c: String)
  : ConceptDesignationTerminologyAxiom
  = upickle.default.read[ConceptDesignationTerminologyAxiom](c)

}	

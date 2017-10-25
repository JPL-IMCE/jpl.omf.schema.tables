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

 
package gov.nasa.jpl.imce.oml.tables

import scala.annotation.meta.field
import scala.scalajs.js.annotation.{JSExport,JSExportTopLevel}
import scala._
import scala.Predef._

/**
  * @param uuid[1,1]
  * @param tboxUUID[1,1]
  * @param name[1,1]
  * @param headUUID[1,1]
  */
@JSExportTopLevel("ChainRule")
case class ChainRule
(
  @(JSExport @field) uuid: UUID,
  @(JSExport @field) tboxUUID: UUID,
  @(JSExport @field) name: LocalName,
  @(JSExport @field) headUUID: UUID
) {
  // Ctor(uuidWithGenerator)   
  def this(
    oug: gov.nasa.jpl.imce.oml.uuid.OMLUUIDGenerator,
    tboxUUID: UUID,
    name: LocalName,
    headUUID: UUID)
  = this(
      oug.namespaceUUID(
        tboxUUID,
        "name" -> name).toString,
      tboxUUID,
      name,
      headUUID)

val vertexId: scala.Long = uuid.hashCode.toLong

  override val hashCode
  : scala.Int 
  = (uuid, tboxUUID, name, headUUID).##
  
  override def equals(other: scala.Any): scala.Boolean = other match {
  	case that: ChainRule =>
  	  (this.uuid == that.uuid) &&
  	  (this.tboxUUID == that.tboxUUID) &&
  	  (this.name == that.name) &&
  	  (this.headUUID == that.headUUID)
    case _ =>
      false
  }
  
}

@JSExportTopLevel("ChainRuleHelper")
object ChainRuleHelper {

  val TABLE_JSON_FILENAME 
  : scala.Predef.String 
  = "ChainRules.json"
  
  implicit val w
  : upickle.default.Writer[ChainRule]
  = upickle.default.macroW[ChainRule]

  @JSExport
  def toJSON(c: ChainRule)
  : String
  = upickle.default.write(expr=c, indent=0)

  implicit val r
  : upickle.default.Reader[ChainRule]
  = upickle.default.macroR[ChainRule]

  @JSExport
  def fromJSON(c: String)
  : ChainRule
  = upickle.default.read[ChainRule](c)

}	
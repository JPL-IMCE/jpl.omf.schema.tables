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
import scala.Predef.ArrowAssoc

/**
  * @param uuid[1,1]
  * @param name[1,1]
  * @param reifiedRelationshipUUID[1,1]
  */
@JSExportTopLevel("InverseProperty")
case class InverseProperty
(
  @(JSExport @field) override val uuid: taggedTypes.InversePropertyUUID,
  @(JSExport @field) val name: taggedTypes.LocalName,
  @(JSExport @field) val reifiedRelationshipUUID: taggedTypes.ReifiedRelationshipUUID
) extends RestrictableRelationship {
  // Ctor(uuidWithContainer)   
  def this(
    oug: gov.nasa.jpl.imce.oml.uuid.OMLUUIDGenerator,
    name: taggedTypes.LocalName,
    reifiedRelationshipUUID: taggedTypes.ReifiedRelationshipUUID)
  = this(
      taggedTypes.inversePropertyUUID(oug.namespaceUUID(
        "InverseProperty",
        "name" -> name,
        "reifiedRelationship" -> reifiedRelationshipUUID).toString),
      name,
      reifiedRelationshipUUID)

val vertexId: scala.Long = uuid.hashCode.toLong

  override val hashCode
  : scala.Int 
  = (uuid, name, reifiedRelationshipUUID).##
  
  override def equals(other: scala.Any): scala.Boolean = other match {
  	case that: InverseProperty =>
  	  (this.uuid == that.uuid) &&
  	  (this.name == that.name) &&
  	  (this.reifiedRelationshipUUID == that.reifiedRelationshipUUID) 
    case _ =>
      false
  }
  
}

@JSExportTopLevel("InversePropertyHelper")
object InversePropertyHelper {

  import io.circe.{Decoder, Encoder, HCursor, Json}
  import io.circe.parser.parse
  import scala.Predef.String

  val TABLE_JSON_FILENAME 
  : String 
  = "InverseProperties.json"

  implicit val decodeInverseProperty: Decoder[InverseProperty]
  = Decoder.instance[InverseProperty] { c: HCursor =>
    
    import cats.syntax.either._
  
    for {
    	  uuid <- c.downField("uuid").as[taggedTypes.InversePropertyUUID]
    	  name <- c.downField("name").as[taggedTypes.LocalName]
    	  reifiedRelationshipUUID <- c.downField("reifiedRelationshipUUID").as[taggedTypes.ReifiedRelationshipUUID]
    	} yield InverseProperty(
    	  uuid,
    	  name,
    	  reifiedRelationshipUUID
    	)
  }
  
  implicit val encodeInverseProperty: Encoder[InverseProperty]
  = new Encoder[InverseProperty] {
    override final def apply(x: InverseProperty): Json 
    = Json.obj(
    	  ("uuid", taggedTypes.encodeInversePropertyUUID(x.uuid)),
    	  ("name", taggedTypes.encodeLocalName(x.name)),
    	  ("reifiedRelationshipUUID", taggedTypes.encodeReifiedRelationshipUUID(x.reifiedRelationshipUUID))
    )
  }

  @JSExport
  def toJSON(c: InverseProperty)
  : String
  = encodeInverseProperty(c).noSpaces

  @JSExport
  def fromJSON(c: String)
  : InverseProperty
  = parse(c) match {
  	case scala.Right(json) =>
  	  decodeInverseProperty(json.hcursor) match {
  	    	case scala.Right(result) =>
  	    	  result
  	    	case scala.Left(failure) =>
  	    	  throw failure
  	  }
    case scala.Left(failure) =>
  	  throw failure
  }

}

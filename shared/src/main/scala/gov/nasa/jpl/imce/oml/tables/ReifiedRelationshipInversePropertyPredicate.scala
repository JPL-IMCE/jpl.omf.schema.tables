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
  * @param inversePropertyUUID[1,1]
  * @param bodySegmentUUID[1,1]
  */
@JSExportTopLevel("ReifiedRelationshipInversePropertyPredicate")
case class ReifiedRelationshipInversePropertyPredicate
(
  @(JSExport @field) override val uuid: taggedTypes.ReifiedRelationshipInversePropertyPredicateUUID,
  @(JSExport @field) val inversePropertyUUID: taggedTypes.InversePropertyUUID,
  @(JSExport @field) override val bodySegmentUUID: taggedTypes.RuleBodySegmentUUID
) extends BinarySegmentReversePropertyPredicate {
  // Ctor(uuidWithContainer)   
  def this(
    oug: gov.nasa.jpl.imce.oml.uuid.OMLUUIDGenerator,
    inversePropertyUUID: taggedTypes.InversePropertyUUID,
    bodySegmentUUID: taggedTypes.RuleBodySegmentUUID)
  = this(
      taggedTypes.reifiedRelationshipInversePropertyPredicateUUID(oug.namespaceUUID(
        "ReifiedRelationshipInversePropertyPredicate",
        "inverseProperty" -> inversePropertyUUID,
        "bodySegment" -> bodySegmentUUID).toString),
      inversePropertyUUID,
      bodySegmentUUID)

val vertexId: scala.Long = uuid.hashCode.toLong

  override val hashCode
  : scala.Int 
  = (uuid, inversePropertyUUID, bodySegmentUUID).##
  
  override def equals(other: scala.Any): scala.Boolean = other match {
  	case that: ReifiedRelationshipInversePropertyPredicate =>
  	  (this.uuid == that.uuid) &&
  	  (this.inversePropertyUUID == that.inversePropertyUUID)  &&
  	  (this.bodySegmentUUID == that.bodySegmentUUID) 
    case _ =>
      false
  }
  
}

@JSExportTopLevel("ReifiedRelationshipInversePropertyPredicateHelper")
object ReifiedRelationshipInversePropertyPredicateHelper {

  import io.circe.{Decoder, Encoder, HCursor, Json}
  import io.circe.parser.parse
  import scala.Predef.String

  val TABLE_JSON_FILENAME 
  : String 
  = "ReifiedRelationshipInversePropertyPredicates.json"

  implicit val decodeReifiedRelationshipInversePropertyPredicate: Decoder[ReifiedRelationshipInversePropertyPredicate]
  = Decoder.instance[ReifiedRelationshipInversePropertyPredicate] { c: HCursor =>
    
    import cats.syntax.either._
  
    for {
    	  uuid <- c.downField("uuid").as[taggedTypes.ReifiedRelationshipInversePropertyPredicateUUID]
    	  inversePropertyUUID <- c.downField("inversePropertyUUID").as[taggedTypes.InversePropertyUUID]
    	  bodySegmentUUID <- c.downField("bodySegmentUUID").as[taggedTypes.RuleBodySegmentUUID]
    	} yield ReifiedRelationshipInversePropertyPredicate(
    	  uuid,
    	  inversePropertyUUID,
    	  bodySegmentUUID
    	)
  }
  
  implicit val encodeReifiedRelationshipInversePropertyPredicate: Encoder[ReifiedRelationshipInversePropertyPredicate]
  = new Encoder[ReifiedRelationshipInversePropertyPredicate] {
    override final def apply(x: ReifiedRelationshipInversePropertyPredicate): Json 
    = Json.obj(
    	  ("uuid", taggedTypes.encodeReifiedRelationshipInversePropertyPredicateUUID(x.uuid)),
    	  ("inversePropertyUUID", taggedTypes.encodeInversePropertyUUID(x.inversePropertyUUID)),
    	  ("bodySegmentUUID", taggedTypes.encodeRuleBodySegmentUUID(x.bodySegmentUUID))
    )
  }

  @JSExport
  def toJSON(c: ReifiedRelationshipInversePropertyPredicate)
  : String
  = encodeReifiedRelationshipInversePropertyPredicate(c).noSpaces

  @JSExport
  def fromJSON(c: String)
  : ReifiedRelationshipInversePropertyPredicate
  = parse(c) match {
  	case scala.Right(json) =>
  	  decodeReifiedRelationshipInversePropertyPredicate(json.hcursor) match {
  	    	case scala.Right(result) =>
  	    	  result
  	    	case scala.Left(failure) =>
  	    	  throw failure
  	  }
    case scala.Left(failure) =>
  	  throw failure
  }

}
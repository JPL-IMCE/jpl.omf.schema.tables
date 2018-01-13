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
  * @param tboxUUID[1,1]
  * @param restrictedDomainUUID[1,1]
  * @param restrictedRangeUUID[1,1]
  * @param restrictedUnreifiedRelationshipUUID[1,1]
  */
@JSExportTopLevel("EntityUniversalUnreifiedRestrictionAxiom")
case class EntityUniversalUnreifiedRestrictionAxiom
(
  @(JSExport @field) override val uuid: taggedTypes.EntityUniversalUnreifiedRestrictionAxiomUUID,
  @(JSExport @field) override val tboxUUID: taggedTypes.TerminologyBoxUUID,
  @(JSExport @field) override val restrictedDomainUUID: taggedTypes.EntityUUID,
  @(JSExport @field) override val restrictedRangeUUID: taggedTypes.EntityUUID,
  @(JSExport @field) override val restrictedUnreifiedRelationshipUUID: taggedTypes.UnreifiedRelationshipUUID
) extends EntityExistentialRestrictionAxiom with EntityUnreifiedRestrictionAxiom {
  // Ctor(uuidWithContainer)   
  def this(
    oug: gov.nasa.jpl.imce.oml.uuid.OMLUUIDGenerator,
    tboxUUID: taggedTypes.TerminologyBoxUUID,
    restrictedDomainUUID: taggedTypes.EntityUUID,
    restrictedRangeUUID: taggedTypes.EntityUUID,
    restrictedUnreifiedRelationshipUUID: taggedTypes.UnreifiedRelationshipUUID)
  = this(
      taggedTypes.entityUniversalUnreifiedRestrictionAxiomUUID(oug.namespaceUUID(
        "EntityUniversalUnreifiedRestrictionAxiom",
        "tbox" -> tboxUUID,
        "restrictedDomain" -> restrictedDomainUUID,
        "restrictedRange" -> restrictedRangeUUID,
        "restrictedUnreifiedRelationship" -> restrictedUnreifiedRelationshipUUID).toString),
      tboxUUID,
      restrictedDomainUUID,
      restrictedRangeUUID,
      restrictedUnreifiedRelationshipUUID)

val vertexId: scala.Long = uuid.hashCode.toLong

  override val hashCode
  : scala.Int 
  = (uuid, tboxUUID, restrictedDomainUUID, restrictedRangeUUID, restrictedUnreifiedRelationshipUUID).##
  
  override def equals(other: scala.Any): scala.Boolean = other match {
  	case that: EntityUniversalUnreifiedRestrictionAxiom =>
  	  (this.uuid == that.uuid) &&
  	  (this.tboxUUID == that.tboxUUID)  &&
  	  (this.restrictedDomainUUID == that.restrictedDomainUUID)  &&
  	  (this.restrictedRangeUUID == that.restrictedRangeUUID)  &&
  	  (this.restrictedUnreifiedRelationshipUUID == that.restrictedUnreifiedRelationshipUUID) 
    case _ =>
      false
  }
  
}

@JSExportTopLevel("EntityUniversalUnreifiedRestrictionAxiomHelper")
object EntityUniversalUnreifiedRestrictionAxiomHelper {

  import io.circe.{Decoder, Encoder, HCursor, Json}
  import io.circe.parser.parse
  import scala.Predef.String

  val TABLE_JSON_FILENAME 
  : String 
  = "EntityUniversalUnreifiedRestrictionAxioms.json"

  implicit val decodeEntityUniversalUnreifiedRestrictionAxiom: Decoder[EntityUniversalUnreifiedRestrictionAxiom]
  = Decoder.instance[EntityUniversalUnreifiedRestrictionAxiom] { c: HCursor =>
    
    import cats.syntax.either._
  
    for {
    	  uuid <- c.downField("uuid").as[taggedTypes.EntityUniversalUnreifiedRestrictionAxiomUUID]
    	  tboxUUID <- c.downField("tboxUUID").as[taggedTypes.TerminologyBoxUUID]
    	  restrictedDomainUUID <- c.downField("restrictedDomainUUID").as[taggedTypes.EntityUUID]
    	  restrictedRangeUUID <- c.downField("restrictedRangeUUID").as[taggedTypes.EntityUUID]
    	  restrictedUnreifiedRelationshipUUID <- c.downField("restrictedUnreifiedRelationshipUUID").as[taggedTypes.UnreifiedRelationshipUUID]
    	} yield EntityUniversalUnreifiedRestrictionAxiom(
    	  uuid,
    	  tboxUUID,
    	  restrictedDomainUUID,
    	  restrictedRangeUUID,
    	  restrictedUnreifiedRelationshipUUID
    	)
  }
  
  implicit val encodeEntityUniversalUnreifiedRestrictionAxiom: Encoder[EntityUniversalUnreifiedRestrictionAxiom]
  = new Encoder[EntityUniversalUnreifiedRestrictionAxiom] {
    override final def apply(x: EntityUniversalUnreifiedRestrictionAxiom): Json 
    = Json.obj(
    	  ("uuid", taggedTypes.encodeEntityUniversalUnreifiedRestrictionAxiomUUID(x.uuid)),
    	  ("tboxUUID", taggedTypes.encodeTerminologyBoxUUID(x.tboxUUID)),
    	  ("restrictedDomainUUID", taggedTypes.encodeEntityUUID(x.restrictedDomainUUID)),
    	  ("restrictedRangeUUID", taggedTypes.encodeEntityUUID(x.restrictedRangeUUID)),
    	  ("restrictedUnreifiedRelationshipUUID", taggedTypes.encodeUnreifiedRelationshipUUID(x.restrictedUnreifiedRelationshipUUID))
    )
  }

  @JSExport
  def toJSON(c: EntityUniversalUnreifiedRestrictionAxiom)
  : String
  = encodeEntityUniversalUnreifiedRestrictionAxiom(c).noSpaces

  @JSExport
  def fromJSON(c: String)
  : EntityUniversalUnreifiedRestrictionAxiom
  = parse(c) match {
  	case scala.Right(json) =>
  	  decodeEntityUniversalUnreifiedRestrictionAxiom(json.hcursor) match {
  	    	case scala.Right(result) =>
  	    	  result
  	    	case scala.Left(failure) =>
  	    	  throw failure
  	  }
    case scala.Left(failure) =>
  	  throw failure
  }

}
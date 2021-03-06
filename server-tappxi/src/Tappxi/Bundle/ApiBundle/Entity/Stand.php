<?php

namespace Tappxi\Bundle\ApiBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Tappxi\Bundle\ApiBundle\Entity\Stand
 *
 * @ORM\Table(name="stand")
 * @ORM\Entity
 */
class Stand
{
    /**
     * @var integer $id
     *
     * @ORM\Column(name="id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var string $name
     *
     * @ORM\Column(name="name", type="string", length=60, nullable=false)
     */
    private $name;

    /**
     * @var float $startFare
     *
     * @ORM\Column(name="start_fare", type="float", nullable=false)
     */
    private $startFare;

    /**
     * @var string $phone
     *
     * @ORM\Column(name="phone", type="string", nullable=true)
     */
    private $phone;

    /**
     * @var integer $status
     *
     * @ORM\Column(name="status", type="smallint", nullable=false)
     */
    private $status;

    /**
     * @var Address
     *
     * @ORM\ManyToOne(targetEntity="Address")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="address_id", referencedColumnName="id")
     * })
     */
    private $address;



    /**
     * Get id
     *
     * @return integer
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set name
     *
     * @param string $name
     * @return Stand
     */
    public function setName($name)
    {
        $this->name = $name;

        return $this;
    }

    /**
     * Get name
     *
     * @return string
     */
    public function getName()
    {
        return $this->name;
    }

    /**
     * Set startFare
     *
     * @param float $startFare
     * @return Stand
     */
    public function setStartFare($startFare)
    {
        $this->startFare = $startFare;

        return $this;
    }

    /**
     * Get startFare
     *
     * @return float
     */
    public function getStartFare()
    {
        return $this->startFare;
    }

    /**
     * Set status
     *
     * @param integer $status
     * @return Stand
     */
    public function setStatus($status)
    {
        $this->status = $status;

        return $this;
    }

    /**
     * Get status
     *
     * @return integer
     */
    public function getStatus()
    {
        return $this->status;
    }

    /**
     * Set address
     *
     * @param Tappxi\Bundle\ApiBundle\Entity\Address $address
     * @return Stand
     */
    public function setAddress(\Tappxi\Bundle\ApiBundle\Entity\Address $address = null)
    {
        $this->address = $address;

        return $this;
    }

    /**
     * Get address
     *
     * @return Tappxi\Bundle\ApiBundle\Entity\Address
     */
    public function getAddress()
    {
        return $this->address;
    }

    public function setPhone($phone){
        $this->phone = $phone;
    }

    public function getPhone(){
        return $this->phone;
    }

    public function toArray(){
        return array(
            'id' => $this->getId(),
            'name' => $this->getName(),
            'address' => $this->address->toArray(),
            'start_fare' => $this->startFare,
            'status' => $this->getStatus(),
            'status_name' => $this->getStatusName(),
            'phone' => $this->getPhone(),
        );
    }

    public function toJson(){
        return json_encode($this->toArray());
    }

    public function getStatusName(){
        return $this->getStatus() == 1 ? "Activo" : "Inactivo";
    }

}